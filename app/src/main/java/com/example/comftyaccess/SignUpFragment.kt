package com.example.comftyaccess

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentSignUpBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.User
import com.google.firebase.auth.FirebaseAuth


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val accessNeedsOptions = Model.accessNeedsOptions
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private var isAvatarSelected = false
    private var accessNeedType: String? = null

    private lateinit var cameraLauncher: ActivityResultLauncher<Void?>
    private lateinit var galleryLauncher: ActivityResultLauncher<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        setupActivityResultLaunchers()
        setupListeners()
        createAccessNeedSpinner()
        return binding.root
    }

    private fun createAccessNeedSpinner() {
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, accessNeedsOptions)
        binding.accessNeedSpinner.adapter = adapter
        binding.accessNeedSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                accessNeedType = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setupActivityResultLaunchers() {
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let {
                binding.userImage.setImageBitmap(it)
                isAvatarSelected = true
            }
        }

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                binding.userImage.setImageURI(it)
                isAvatarSelected = true
            }
        }

        binding.btnCamera.setOnClickListener {
            cameraLauncher.launch(null)
        }

        binding.btnGallery.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }

    private fun setupListeners() {
        binding.signUpBtn.setOnClickListener {
            val fullName = binding.fullNameEditText.text.toString()
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString()
            val age = binding.ageEditText.text.toString().toIntOrNull() ?: 18
            val accessNeed = accessNeedType ?: ""

            if (email.isNotEmpty() && password.isNotEmpty() && fullName.isNotEmpty()) {
                registerUser(email, password, fullName, age, accessNeed, "")

            } else {
                Toast.makeText(context, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            }

        }

        binding.signInHereIBtn.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }
    }

    private fun registerUser(email: String, password: String, fullName: String, age: Int, accessNeed: String, imageUrl: String) {
        Log.d("SignUpFragment", "Trying to sign up")
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("SignUpFragment", "User can be created")
                if (isAvatarSelected) {
                    Log.d("SignUpFragment", "isAvatarSelected = true")
                    (binding.userImage.drawable as? BitmapDrawable)?.let { drawable ->
                        val bitmap = drawable.bitmap
                        Model.instance.uploadImage(email, bitmap) { url ->
                            Log.d("SignUpFragment", "URL: ${url ?: "not available"}")
                            val newUser = User(fullName, email, age, accessNeed, url ?: imageUrl)
                            Model.instance.addUser(newUser) {
                                Log.d("SignUpFragment", "User with image added")
                                startActivity(Intent(activity, MainActivity::class.java))
                                activity?.finish()
                            }
                        }
                    } ?: Log.e("SignUpFragment", "Failed to cast drawable to BitmapDrawable")
                } else {
                    val newUser = User(fullName, email, age, accessNeed, imageUrl)
                    Model.instance.addUser(newUser) {
                        Log.d("SignUpFragment", "User without image added")
                        startActivity(Intent(activity, MainActivity::class.java))
                        activity?.finish()
                    }
                }
            } else {
                Toast.makeText(context, "Registration failed: ${task.exception?.localizedMessage}", Toast.LENGTH_LONG).show()
                Log.e("SignUpFragment", "Registration failed", task.exception)
            }
        }
    }

}