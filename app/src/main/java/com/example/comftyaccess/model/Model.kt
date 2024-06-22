package com.example.comftyaccess.model

import Review
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

    fun getAllReviews(): LiveData<List<Review>> {
        if (reviewsList == null) {
            reviewsList = localDb.reviewDao().getAllReviews()
        }
        return reviewsList!!
    }
}