package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_review, container, false)

        // Here we manually add a review
        addTestReview()

        return view
    }

    private fun addTestReview() {
        val newReview = Review(
            reviewId = 0, // AutoGenerate should handle the ID
            hotelName = "Test Hotel",
            email = "test@example.com",
            rate = 5,
            age = 25,
            accessNeed = "Mobility Impairment",
            img = "url_to_image",
            description = "This is a test review."
        )

         Model.instance.addReview(newReview) {
             Toast.makeText(
                        context, // Make sure to use requireContext() to avoid context-related issues
                        "Review added!",
                        Toast.LENGTH_LONG
                    ).show()
                }
             Log.d("AddReviewFragment", "Review inserted")

        }




}