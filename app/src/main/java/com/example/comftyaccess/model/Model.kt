package com.example.comftyaccess.model

import android.util.Log
import androidx.lifecycle.LiveData

class Model {

    private var reviewsList: LiveData<List<Review>>? = null
    private val localDb: AppLocalDBRepository = AppLocalDB.appLocalDBRepository

    companion object {
        val accessNeedsOptions = listOf(
            "Do not want to share",
            "Visual Impairment",
            "Hearing Impairment",
            "Mobility Impairment",
            "Cognitive Impairment",
            "Neurodiverse",
            "Speech Impairment",
            "Other"
        )

        // Singleton instance of Model, directly accessible as Model.instance
        val instance: Model = Model()
    }

    interface Listener<T> {
        fun onComplete(data: T)
    }

    interface ListenerVoid<Void> {
        fun onComplete()
    }


    fun getAllReviews(): LiveData<List<Review>> {
        val reviewsList = localDb.reviewDao().getAllReviews()
        Log.d("AllReviewsFragment", "Attempting to log size of LiveData which is not directly possible")
        return reviewsList
    }
}