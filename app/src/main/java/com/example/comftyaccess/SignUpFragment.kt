package com.example.comftyaccess

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentSignUpBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private var action: NavDirections? = null
    private val accessNeedsOptions =  Model.accessNeedsOptions
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }


    private var accessNeedType: String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        setupListeners()
        createAccessNeedSpinner()
        return binding.root
    }

    private fun createAccessNeedSpinner() {
        val adapter = ArrayAdapter(
            requireContext(), // Use requireContext() within Fragments
            R.layout.spinner_item, // Your custom item layout
            accessNeedsOptions // The list of options
        )
        binding.accessNeedSpinner.adapter = adapter

        binding.accessNeedSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
               accessNeedType = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setupListeners() {
        binding.signUpBtn.setOnClickListener {
            val fullName = binding.fullNameEditText.text.toString()
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString()
            val age = binding.ageEditText.text.toString().toIntOrNull() ?: 18 // Default to 18 if empty
            val accessNeed = accessNeedType ?: ""

            if (email.isNotEmpty() && password.isNotEmpty() && fullName.isNotEmpty()) {
                registerUser(email, password, fullName, age, accessNeed)
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signInHereIBtn.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }
    }

    private fun registerUser(email: String, password: String, fullName: String, age: Int, accessNeed: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { authResult ->
                if (authResult.isSuccessful) {
                    val user = authResult.result?.user
                    user?.let {
                        // Create a new User object
                        val newUser = User(
                            email = email,
                            name = fullName,
                            age = age,
                            accessNeed = accessNeed
                        )
                        // Save the user details to Firestore
                        Model.instance.addUser(newUser) {
                            val i = Intent(activity, MainActivity::class.java)
                            startActivity(i)
                        }
                    }
                } else {
                    Log.e("FirebaseAuth", "Registration failed", authResult.exception)
                    Toast.makeText(context, "Registration failed: ${authResult.exception?.localizedMessage}", Toast.LENGTH_LONG).show()                }
            }
    }



}