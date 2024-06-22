package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.comftyaccess.model.AppLocalDB
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

        lifecycleScope.launch(Dispatchers.IO) {  // Ensuring execution on background thread
            AppLocalDB.appLocalDBRepository.reviewDao().insertAll(newReview)
            Log.d("AddReviewFragment", "Review inserted")
        }
    }



}