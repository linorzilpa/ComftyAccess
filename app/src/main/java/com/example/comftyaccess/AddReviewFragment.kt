package com.example.comftyaccess

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.comftyaccess.databinding.FragmentAddReviewBinding
import com.example.comftyaccess.databinding.FragmentSignInBinding
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review
import com.example.comftyaccess.model.User
import com.google.firebase.auth.FirebaseAuth

class AddReviewFragment : Fragment() {
    private lateinit var binding: FragmentAddReviewBinding
    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private var email= ""
    private lateinit var cameraLauncher: ActivityResultLauncher<Void?>
    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    private var isAvatarSelected = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddReviewBinding.inflate(inflater, container, false)

        if (auth.currentUser == null) {
            showLoginDialog()
        }
        else{
            //if the user is logged in\
            setupActivityResultLaunchers()
            setupStarRating()
            email = auth.getCurrentUser()?.getEmail().toString()
            binding.emailTvAddReview.setText(email)
        }
        binding.btAddReview.setOnClickListener {
            val description = binding.descriptionEditTextAddReview.text?.toString() ?: ""
            var hotelName = binding.hotelNameSpinnerAddReview.selectedItem?.toString() ?: "" // Ensures null safety
            hotelName = "example"
            val rate = getSelectedRate()

            if (description.isEmpty() || hotelName.isEmpty() || rate == 0) {
                Toast.makeText(requireContext(), "Please fill all fields.", Toast.LENGTH_SHORT).show()
            } else {
                addReview(description, hotelName, rate)
            }
        }


        return binding.root
    }

    private fun showLoginDialog() {
        context?.let {
            AlertDialog.Builder(it)
                .setTitle("Authentication Required")
                .setMessage("You need to log in or sign up to add a review.")
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

    private fun addReview(description: String, hotelName: String, rate: Int) {
        Model.instance.getAllUsers { users ->
            val user = users?.let { Model.instance.getUserByEmail(it, email) }
            if (user != null) {
                // Ensure all properties are set before creating Review
                val accessNeed = user.accessNeed ?: "Default Access Need"
                val age = user.age
                val newReview = Review(
                        hotelName = hotelName,
                        email = email,
                        rate = rate,
                        age = age,
                        accessNeed = accessNeed,
                        img = "",
                        description = description
                    )
                    newReview.generateID()
                if (isAvatarSelected) {
                    (binding.ivAddReview.drawable as? BitmapDrawable)?.let { drawable ->
                        val bitmap = drawable.bitmap
                        Model.instance.uploadImage(newReview.reviewId.toString(), bitmap) { url ->
                            newReview.img=url!!
                            Model.instance.addReview(newReview) {
                                Toast.makeText(requireContext(), "Review added!", Toast.LENGTH_LONG).show()
                                Log.d("AddReviewFragment", "Review inserted with img")
                            }
                        }
                    } ?: Log.e("SignUpFragment", "Failed to cast drawable to BitmapDrawable")
                } else{
                    Model.instance.addReview(newReview) {
                        Toast.makeText(requireContext(), "Review added!", Toast.LENGTH_LONG).show()
                        Log.d("AddReviewFragment", "Review inserted without img")
                    }
                }
            } else {
                Log.d("AddReviewFragment", "No user found with email: $email")
                Toast.makeText(requireContext(), "Failed to add review: User not found", Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun getSelectedRate(): Int {
        val stars = arrayOf(
            binding.rowStar1AddReview,
            binding.rowStar2AddReview,
            binding.rowStar3AddReview,
            binding.rowStar4AddReview,
            binding.rowStar5AddReview
        )
        var rate = 0
        stars.forEachIndexed { index, imageView ->
            // Check if the current star is filled
            if (imageView.drawable.constantState == resources.getDrawable(R.drawable.baseline_star_rate_24, null).constantState) {
                rate = index + 1  // Update rate based on the filled star's index
            }
        }
        return rate
    }


    private fun setupStarRating() {
        val stars = arrayOf(
            binding.rowStar1AddReview,
            binding.rowStar2AddReview,
            binding.rowStar3AddReview,
            binding.rowStar4AddReview,
            binding.rowStar5AddReview
        )

        stars.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                updateStars(stars, index + 1)  // Pass index + 1 because index is zero-based but rate should start from 1
            }
        }
    }

    private fun updateStars(stars: Array<ImageView>, rate: Int) {
        stars.forEachIndexed { index, imageView ->
            if (index < rate) {
                imageView.setImageResource(R.drawable.baseline_star_rate_24)  // Filled star drawable
            } else {
                imageView.setImageResource(R.drawable.baseline_star_outline_24)  // Outline star drawable
            }
        }
    }

    private fun setupActivityResultLaunchers() {
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let {
                binding.ivAddReview.setImageBitmap(it)
                isAvatarSelected = true
            }
        }

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                binding.ivAddReview.setImageURI(it)
                isAvatarSelected = true
            }
        }

        binding.btnCameraAddReview.setOnClickListener {
            cameraLauncher.launch(null)
        }

        binding.btnGalleryAddReview.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }


}