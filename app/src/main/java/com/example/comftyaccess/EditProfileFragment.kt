package com.example.comftyaccess

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentEditProfileBinding
import com.example.comftyaccess.model.Model
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private var accessNeedType: String? = null
    private val accessNeedsOptions = Model.accessNeedsOptions
    private var isAvatarSelected: Boolean = false
    private lateinit var cameraLauncher: ActivityResultLauncher<Void?>
    private lateinit var galleryLauncher: ActivityResultLauncher<String>

    // Set the action bar title when the fragment starts
    override fun onStart() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Edit profile"
        super.onStart()
    }

    // Inflate the fragment's layout and initialize necessary components
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(layoutInflater)
        binding.progressBarEP.visibility = View.GONE
        createAccessNeedSpinner()
        bindProfile()
        setupActivityResultLaunchers()

        // Handle the Cancel button click event
        binding.cancelBtEprofile.setOnClickListener { view ->
            findNavController().navigateUp()
        }

        // Handle the Save button click event
        binding.saveBtEprofile.setOnClickListener { view ->
            saveUserUpdate()
        }

        return binding.root
    }

    // Save user profile updates
    private fun saveUserUpdate() {
        binding.progressBarEP.visibility = View.VISIBLE
        Model.instance.getAllUsers { users ->
            val userEmail = firebaseAuth.currentUser?.email  // Safe call
            if (userEmail != null) {  // Check if email is not null
                val user = users?.let { Model.instance.getUserByEmail(it, userEmail) }
                user?.let { usr ->
                    activity?.runOnUiThread {
                        // Update user details
                        usr.accessNeed = binding.accessNeedSpinnerSpinnerFilter.selectedItem.toString()
                        usr.age = binding.ageEditText.text.toString().toIntOrNull() ?: usr.age  // Use the existing age if parsing fails
                        usr.name = binding.fullNameEditText.text.toString()

                        // Check if avatar is selected
                        if (isAvatarSelected) {
                            (binding.userEprofileIv.drawable as? BitmapDrawable)?.let { drawable ->
                                val bitmap = drawable.bitmap
                                Model.instance.uploadImage(usr.email, bitmap) { url ->
                                    usr.img = url!!
                                    Log.d("EditProfileFragment", "User img url ${usr.img}")

                                    Model.instance.addUser(usr) {
                                        Toast.makeText(requireContext(), "User updated!", Toast.LENGTH_LONG).show()
                                        Log.d("EditProfileFragment", "User updated with img")
                                        findNavController().navigateUp()  // Navigate up in the navigation stack
                                    }
                                }
                            } ?: Log.e("EditProfileFragment", "Failed to cast drawable to BitmapDrawable")
                        } else {
                            Model.instance.addUser(usr) {
                                Toast.makeText(requireContext(), "User updated!", Toast.LENGTH_LONG).show()
                                Log.d("EditProfileFragment", "User updated without img")
                                findNavController().navigateUp()  // Navigate up in the navigation stack
                            }
                        }
                    }
                }
            }
            binding.progressBarEP.visibility = View.GONE
        }
    }

    // Bind user profile data to the UI
    @SuppressLint("SetTextI18n")
    private fun bindProfile() {
        binding.progressBarEP.visibility = View.VISIBLE
        val userEmail = firebaseAuth.currentUser?.email
        if (userEmail != null) {
            Model.instance.getAllUsers { users ->
                // This callback might be called from a background thread, so switch to the main thread
                val user = Model.instance.getUserByEmail(users!!, userEmail)
                user?.let { usr ->
                    // Now bind the user information to the TextViews
                    binding.fullNameEditText.setText(usr.name)
                    binding.emailEprofileTv.text = usr.email
                    binding.ageEditText.setText(usr.age.toString())  // Correct way to set integer value as text
                    binding.helloEprofileTv.text = "Hello ${usr.name}"
                    val accessNeedIndex = (binding.accessNeedSpinnerSpinnerFilter.adapter as ArrayAdapter<String>).getPosition(usr.accessNeed)
                    binding.accessNeedSpinnerSpinnerFilter.setSelection(accessNeedIndex)
                    usr.img?.let { imageUrl ->
                        if (imageUrl.isNotBlank()) {
                            Picasso.get().load(imageUrl)
                                .placeholder(R.drawable.ic_launcher_foreground)  // Placeholder image
                                .error(R.drawable.ic_launcher_foreground)         // Error image
                                .into(binding.userEprofileIv)
                        } else {
                            binding.userEprofileIv.setImageResource(R.drawable.ic_launcher_foreground)
                        }
                    } ?: binding.userEprofileIv.setImageResource(R.drawable.ic_launcher_foreground)
                }
                binding.progressBarEP.visibility = View.GONE
            }
        }
    }

    // Create the Access Need spinner and set its options
    private fun createAccessNeedSpinner() {
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, accessNeedsOptions)
        binding.accessNeedSpinnerSpinnerFilter.adapter = adapter
        binding.accessNeedSpinnerSpinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                accessNeedType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    // Set up activity result launchers for the camera and gallery
    private fun setupActivityResultLaunchers() {
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let {
                binding.userEprofileIv.setImageBitmap(it)
                isAvatarSelected = true
            }
        }

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                binding.userEprofileIv.setImageURI(it)
                isAvatarSelected = true
            }
        }

        // Set up the button click listeners for camera and gallery
        binding.eProfileCameraBt.setOnClickListener {
            cameraLauncher.launch(null)
        }

        binding.eProfileGalleryIv.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }
}