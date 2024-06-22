package com.example.comftyaccess

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.comftyaccess.model.AppLocalDB
import com.example.comftyaccess.model.Model
import com.example.comftyaccess.model.Review


class AllReviewsViewModel : ViewModel() {
    private val repository = Model.instance  // Assuming Model.instance manages database operations

    val data: LiveData<List<Review>> by lazy {
        repository.getAllReviews()  // This should internally handle moving work off the main thread
    }
}