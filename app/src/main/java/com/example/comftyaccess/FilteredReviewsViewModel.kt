package com.example.comftyaccess

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review

class FilteredReviewsViewModel : ViewModel() {

        private val repository = Model.instance  // Assuming Model.instance manages database operations

    fun filterReviews(
        reviews: List<Review>?,
        accessNeedType: String?,
        ageRangeType: String,
        email: String,
        rating: String
    ): List<Review> {
        return repository.getFilterReviews(reviews, accessNeedType, ageRangeType, email, rating)
    }

    val data: LiveData<List<Review>> by lazy {
        repository.getAllReviews()  // This should internally handle moving work off the main thread
    }

}