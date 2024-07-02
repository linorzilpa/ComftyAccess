package com.example.comftyaccess

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentAllReviewsBinding
import com.example.comftyaccess.databinding.FragmentMyProfileBinding
import com.example.comftyaccess.databinding.FragmentSignInBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.User
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso


class MyProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentMyProfileBinding
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onStart() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "My profile"
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyProfileBinding.inflate(layoutInflater)
        if (firebaseAuth.currentUser == null) {
            showLoginDialog()
        }

        bindProfile()
        binding.myReviewsMyprofileBt.setOnClickListener {
            val action = MyProfileFragmentDirections.actionMyProfileFragmentToFilteredReviewsFragment(
                 firebaseAuth.currentUser!!.email ?: "Rather not to mention",
                "Rather not to mention",
                 "Rather not to mention",
                "Rather not to mention",
                "Rather not to mention"
            )
            findNavController().navigate(action)

        }
        binding.editMyprofileIv.setOnClickListener { view ->
            val action = MyProfileFragmentDirections.actionMyProfileFragmentToEditProfileFragment()
            findNavController().navigate(action)
        }
        binding.editMyprofileIv2.setOnClickListener { view ->
            val action = MyProfileFragmentDirections.actionMyProfileFragmentToEditProfileFragment()
            findNavController().navigate(action)
        }

        return binding.root
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
                        binding.fullnameProfileTv.text = usr.name
                        binding.emailProfileTv.text = usr.email
                        binding.ageProfileTv.text = usr.age.toString()
                        binding.accessneedProfileTv.text = usr.accessNeed
                        binding.helloProfileTv.text = "Hello ${usr.name}"
                        usr.img?.let { imageUrl ->
                            if (imageUrl.isNotBlank()) {
                                Picasso.get().load(imageUrl)
                                    .placeholder(R.drawable.ic_launcher_foreground)  // Placeholder image
                                    .error(R.drawable.ic_launcher_foreground)         // Error image
                                    .into(binding.userProfileIv)
                            } else {
                                binding.userProfileIv.setImageResource(R.drawable.ic_launcher_foreground)
                            }
                        } ?: binding.userProfileIv.setImageResource(R.drawable.ic_launcher_foreground)


                    }

                }
            }
    }

    private fun showLoginDialog() {
        context?.let {
            AlertDialog.Builder(it)
                .setTitle("Authentication Required")
                .setMessage("You need to log in or sign up to access profile page.")
                .setPositiveButton("Log In") { dialog, which ->
                    val i = Intent(activity, ConnectActivity::class.java)
                    startActivity(i)
                    activity?.finish()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    findNavController().navigateUp()  // Navigate up in the navigation stack
                    dialog.dismiss()
                }

                .setCancelable(false)  // Prevent dialog from being dismissed on back press
                .show()
        }
    }

}