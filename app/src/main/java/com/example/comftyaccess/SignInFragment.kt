package com.example.comftyaccess

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInFragment : Fragment() {
    // View binding for the fragment layout
    private lateinit var binding: FragmentSignInBinding

    // Firebase authentication instance
    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    // Inflate the fragment's layout and initialize necessary components
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        // Hide the progress bar initially
        binding.progressBarSI.visibility = View.GONE

        // Set up the button click listener for navigating to the Sign Up screen
        binding.signUpHereBtn.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            findNavController().navigate(action)
        }

        // Set up the button click listener for signing in the user
        binding.signInBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()  // Trim to remove any leading/trailing spaces
            val password = binding.passEditText.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                signInUser(email, password)
            }
        }

        return binding.root
    }

    // Sign in the user with the provided email and password
    private fun signInUser(email: String, password: String) {
        // Show the progress bar
        binding.progressBarSI.visibility = View.VISIBLE
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Navigate to the MainActivity if sign-in is successful
                val i = Intent(activity, MainActivity::class.java)
                startActivity(i)
                activity?.finish()
            } else {
                // Show an error message if sign-in fails
                Toast.makeText(context, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
            }
            // Hide the progress bar
            binding.progressBarSI.visibility = View.GONE
        }
    }

    // Set the action bar title when the fragment starts
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Sign in"
    }
}