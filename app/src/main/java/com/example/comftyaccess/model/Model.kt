package com.example.comftyaccess.model

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Model {

    private val localDb: AppLocalDBRepository = AppLocalDB.appLocalDBRepository
    private val firebaseModel: FireBaseModel = FireBaseModel()
    private var reviewsList: LiveData<List<Review>>? = null


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

        val ageRangeOptions = listOf(
            "18-30",
            "30-40",
            "40-50",
            "50-60",
            "60+"
        )

        // Singleton instance of Model
        val instance: Model by lazy { Model() }
    }

    fun interface Listener<T> {
        fun onComplete(data: T?)
    }

    fun interface ListenerVoid {
        fun onComplete()
    }

    enum class LoadingState {
        LOADING,
        NOT_LOADING
    }

    val reviewsListLoadingState = MutableLiveData<LoadingState>().apply {
        value = LoadingState.NOT_LOADING
    }

    fun addUser(user: User, listener: ListenerVoid) {
        CoroutineScope(Dispatchers.IO).launch {
            firebaseModel.addUser(user) { listener.onComplete() }
        }
    }



    fun getAllUsers(callback: Listener<List<User>>) {
        CoroutineScope(Dispatchers.IO).launch {
            firebaseModel.getAllUsers(callback)
        }
    }

    fun getUserByEmail(users: List<User>, email: String): User? {
        return users.firstOrNull { it.email == email }
    }

    fun getAllReviews(): LiveData<List<Review>> {
        if (reviewsList == null) {
            reviewsList = localDb.reviewDao().getAllReviews()
            refreshAllReviews()
        }
        return reviewsList!!
    }

    @SuppressLint("SuspiciousIndentation")
    fun refreshAllReviews() {
        reviewsListLoadingState.postValue(LoadingState.LOADING)
        val localLastUpdate = Review.getLocalLastUpdate()
            firebaseModel.getAllReviewsSince(localLastUpdate) { list ->
                CoroutineScope(Dispatchers.IO).launch {
                        if (list != null) {
                            Log.d("Model", "Firebase returned: ${list.size}")
                        }
                        var time = localLastUpdate
                    if (list != null) {
                        list.forEach { review ->
                            localDb.reviewDao().insertAll(review)
                            if (time < review.lastUpdated!!) {
                                time = review.lastUpdated!!
                            }
                        }
                    }
                    Review.setLocalLastUpdate(time)
                    reviewsListLoadingState.postValue(LoadingState.NOT_LOADING)
                }
            }

    }

    //**********************************************Reviews***************************************
    fun generateID(l: LiveData<List<Review>>?): Int {
        var maxID = 0
        return if (l == null) {
            maxID
        } else {
            for (r in l.getValue()!!) {
                if (r.reviewId > maxID) {
                    maxID = r.reviewId
                }
            }
            maxID + 1
        }
    }



    fun addReview(review: Review, listener: ListenerVoid) {
            firebaseModel.addReview(review) {
                refreshAllReviews()
                listener.onComplete()
            }
    }


    fun getMyReviews(all: List<Review>, email: String): List<Review> {
        return all.filter { it.email == email }
    }

    fun uploadImage(name: String, bitmap: Bitmap, listener: Listener<String>) {
        CoroutineScope(Dispatchers.IO).launch {
            firebaseModel.uploadImage(name, bitmap, listener)
        }
    }

    fun getFilterReviews(reviews: List<Review>?, accessNeedType: String?, ageRangeType: String?, email: String?, rating: String?): List<Review> {
        Log.d("FilterDebug", "Starting filter process...")
        Log.d("FilterDebug", "Filter Parameters: AccessNeedType='$accessNeedType', AgeRangeType='$ageRangeType', Email='$email', Rating='$rating'")

        val filteredReviews = reviews?.filter { review ->
            val byAccessNeed = accessNeedType?.takeUnless { it == "Rather not to mention" }?.let { review.accessNeed == it } ?: true
            val byAgeRange = ageRangeType?.takeUnless { it == "Rather not to mention" }?.let { ageRangeMatches(review.age, it) } ?: true
            val byEmail = email?.takeUnless { it == "Rather not to mention" }?.let { review.email == it } ?: true
            val byRating = rating?.takeUnless { it == "Rather not to mention" }?.let { review.rate.toString() == it } ?: true

            // Debug log to check which reviews are passing the filters
            Log.d("FilterDebug", "Review: ${review.hotelName}, AccessNeed: ${review.accessNeed}, Age: ${review.age}, Email: ${review.email}, Rate: ${review.rate}, Matches: ${byAccessNeed && byAgeRange && byEmail && byRating}")

            byAccessNeed && byAgeRange && byEmail && byRating
        } ?: emptyList()

        Log.d("FilterDebug", "Filtered reviews count: ${filteredReviews.size}")
        return filteredReviews
    }

    private fun ageRangeMatches(age: Int, ageRange: String): Boolean {
        return when (ageRange) {
            "18-30" -> age in 18..30
            "30-40" -> age in 31..40
            "40-50" -> age in 41..50
            "50-60" -> age in 51..60
            "60+" -> age >= 61
            else -> false
        }
    }


}