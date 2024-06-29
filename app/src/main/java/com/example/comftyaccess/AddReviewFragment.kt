package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review

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
            hotelName = "Test Hotel",
            email = "xw1@example.com",
            rate = 3,
            age = 18,
            accessNeed = "Speech Impairment",
            img = "url_to_image",
            description = "This is a test review."
        )
        newReview.generateID()
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