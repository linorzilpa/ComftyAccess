package com.example.comftyaccess

import Review
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.comftyaccess.model.Model

class AllReviewsViewModel : ViewModel() {

    // Assuming Model.instance().getAllRecommendations() returns LiveData<List<Review>>
    val data: LiveData<List<Review>> = Model.instance.getAllReviews()


}