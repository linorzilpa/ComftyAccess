package com.example.comftyaccess

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FilteredReviewsFragment : Fragment() {
    // Initialize fields for received arguments
    private var accessNeedType: String? = null
    private var ageRangeType: String? = null
    private var email: String? = null
    private var rating: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            accessNeedType = it.getString("accessNeedType")
            ageRangeType = it.getString("ageRangeType")
            email = it.getString("email")
            if(email.equals(""))
                email= "Rather not to mention"
            rating = it.getString("rating")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FilteredReviewsFragment", "Access Need Type: $accessNeedType")
        Log.d("FilteredReviewsFragment", "Age Range Type: $ageRangeType")
        Log.d("FilteredReviewsFragment", "Email: $email")
        Log.d("FilteredReviewsFragment", "Rating: $rating")
        return inflater.inflate(R.layout.fragment_filtered_reviews, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(accessNeedType: String, ageRangeType: String, email: String, rating: String) =
            FilteredReviewsFragment().apply {
                arguments = Bundle().apply {
                    putString("accessNeedType", accessNeedType)
                    putString("ageRangeType", ageRangeType)
                    putString("email", email)
                    putString("rating", rating)
                }
            }
    }
}