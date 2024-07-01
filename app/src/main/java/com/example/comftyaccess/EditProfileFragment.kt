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
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentEditProfileBinding
import com.example.comftyaccess.databinding.FragmentMyProfileBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private var accessNeedType: String? = null
    private val accessNeedsOptions = Model.accessNeedsOptions
    private var isAvatarSelected:Boolean = false
    private lateinit var cameraLauncher: ActivityResultLauncher<Void?>
    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(layoutInflater)
        createAccessNeedSpinner()
        bindProfile()
        setupActivityResultLaunchers()
        binding.cancelBtEprofile.setOnClickListener { view ->
            findNavController().navigateUp()
        }
        binding.saveBtEprofile.setOnClickListener { view ->
            saveUserUpdate()
        }

        return binding.root
    }

    private fun saveUserUpdate() {
        Model.instance.getAllUsers { users ->
            val userEmail = firebaseAuth.currentUser?.email  // Safe call
            if (userEmail != null) {  // Check if email is not null
                val user = users?.let { Model.instance.getUserByEmail(it, userEmail) }
                user?.let { usr ->
                    activity?.runOnUiThread {

                        usr.accessNeed = binding.accessNeedSpinnerSpinnerFilter.selectedItem.toString()
                        usr.age =  binding.ageEditText.text.toString().toIntOrNull() ?: usr.age  // Use the existing age if parsing fails
                        usr.name = binding.fullNameEditText.text.toString()
                        if (isAvatarSelected) {
                            (binding.userEprofileIv.drawable as? BitmapDrawable)?.let { drawable ->
                                val bitmap = drawable.bitmap
                                Model.instance.uploadImage(usr.email, bitmap) { url ->
                                    usr.img=url!!
                                    Log.d("EditProfileFragment", "user img url ${usr.img.toString()}")

                                    Model.instance.addUser(usr) {
                                        Toast.makeText(requireContext(), "user updated!", Toast.LENGTH_LONG).show()
                                        Log.d("EditProfileFragment", "user updated with img")
                                        findNavController().navigateUp()  // Navigate up in the navigation stack
                                    }
                                }
                            } ?: Log.e("EditProfileFragment", "Failed to cast drawable to BitmapDrawable")
                        } else{
                            Model.instance.addUser(usr) {
                                Toast.makeText(requireContext(), "User updated!", Toast.LENGTH_LONG).show()
                                Log.d("EditProfileFragment", "User updated without img")
                                findNavController().navigateUp()  // Navigate up in the navigation stack
                            }
                        }

                    }
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun bindProfile() {
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

            }
        }
    }

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

        binding.eProfileCameraBt.setOnClickListener {
            cameraLauncher.launch(null)
        }

        binding.eProfileGalleryIv.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }


}