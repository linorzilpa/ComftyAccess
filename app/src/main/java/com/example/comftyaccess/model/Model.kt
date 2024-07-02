package com.example.comftyaccess.model

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Model {

    // Local database repository instance
    private val localDb: AppLocalDBRepository = AppLocalDB.appLocalDBRepository

    // Firebase model instance
    private val firebaseModel: FireBaseModel = FireBaseModel()

    // LiveData list of reviews
    private var reviewsList: LiveData<List<Review>>? = null

    // Companion object for singleton pattern and static properties
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

    // Listener interface for callbacks
    fun interface Listener<T> {
        fun onComplete(data: T?)
    }

    // Listener interface for void callbacks
    fun interface ListenerVoid {
        fun onComplete()
    }

    // Enum for loading state
    enum class LoadingState {
        LOADING,
        NOT_LOADING
    }

    // MutableLiveData for the loading state of reviews list
    val reviewsListLoadingState = MutableLiveData<LoadingState>().apply {
        value = LoadingState.NOT_LOADING
    }

    // Add a new user to the database
    fun addUser(user: User, listener: ListenerVoid) {
        CoroutineScope(Dispatchers.IO).launch {
            firebaseModel.addUser(user) { listener.onComplete() }
        }
    }

    // Fetch all users from the database
    fun getAllUsers(callback: Listener<List<User>>) {
        CoroutineScope(Dispatchers.IO).launch {
            firebaseModel.getAllUsers(callback)
        }
    }

    // Get a user by email from a list of users
    fun getUserByEmail(users: List<User>, email: String): User? {
        return users.firstOrNull { it.email == email }
    }

    // Get all reviews as LiveData
    fun getAllReviews(): LiveData<List<Review>> {
        if (reviewsList == null) {
            reviewsList = localDb.reviewDao().getAllReviews()
            refreshAllReviews()
        }
        return reviewsList!!
    }

    // Refresh all reviews from the database
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
                list?.forEach { review ->
                    if (!review.deleted) {
                        localDb.reviewDao().insertAll(review)
                    } else {
                        localDb.reviewDao().deleteById(review.reviewId.toString())
                    }
                    if (time < review.lastUpdated!!) {
                        time = review.lastUpdated!!
                    }
                }
                Review.setLocalLastUpdate(time)
                reviewsListLoadingState.postValue(LoadingState.NOT_LOADING)
            }
        }
    }


    // Generate a unique ID for a new review
    fun generateID(l: LiveData<List<Review>>?): Int {
        var maxID = 0
        return if (l == null) {
            maxID
        } else {
            l.value?.forEach { review ->
                if (review.reviewId > maxID) {
                    maxID = review.reviewId
                }
            }
            maxID + 1
        }
    }

    // Add a new review to the database
    fun addReview(review: Review, listener: ListenerVoid) {
        firebaseModel.addReview(review) {
            refreshAllReviews()
            listener.onComplete()
        }
    }

    // Delete a new review to the database
    fun deleteReview(review: Review, listener: ListenerVoid) {
        firebaseModel.addReview(review) {
            CoroutineScope(Dispatchers.IO).launch {
                localDb.reviewDao().deleteById(review.reviewId.toString())
                refreshAllReviews() // Ensure the list is refreshed after deletion

                withContext(Dispatchers.Main) {
                    listener.onComplete()
                }
            }
        }
    }


    // Upload an image to Firebase Storage
    fun uploadImage(name: String, bitmap: Bitmap, listener: Listener<String>) {
        CoroutineScope(Dispatchers.IO).launch {
            firebaseModel.uploadImage(name, bitmap, listener)
        }
    }

    // Filter reviews based on multiple criteria
    fun getFilterReviews(
        reviews: List<Review>?,
        accessNeedType: String?,
        ageRangeType: String?,
        email: String?,
        rating: String?,
        hotelName: String?
    ): List<Review> {
        Log.d("FilterDebug", "Starting filter process...")
        Log.d("FilterDebug", "Filter Parameters: AccessNeedType='$accessNeedType', AgeRangeType='$ageRangeType', Email='$email', Rating='$rating', Hotel Name='$hotelName'")

        val filteredReviews = reviews?.filter { review ->
            val byAccessNeed = accessNeedType?.takeUnless { it == "Rather not to mention" }?.let { review.accessNeed == it } ?: true
            val byAgeRange = ageRangeType?.takeUnless { it == "Rather not to mention" }?.let { ageRangeMatches(review.age, it) } ?: true
            val byEmail = email?.takeUnless { it == "Rather not to mention" }?.let { review.email == it } ?: true
            val byRating = rating?.takeUnless { it == "Rather not to mention" }?.let { review.rate.toString() == it } ?: true
            val byHotelName = hotelName?.takeUnless { it == "Rather not to mention" }?.let { review.hotelName == it } ?: true

            // Debug log to check which reviews are passing the filters
            Log.d("FilterDebug", "Review: ${review.hotelName}, AccessNeed: ${review.accessNeed}, Age: ${review.age}, Email: ${review.email}, Rate: ${review.rate}, Hotel Name='$hotelName' Matches: ${byAccessNeed && byAgeRange && byEmail && byRating && byHotelName}")

            byAccessNeed && byAgeRange && byEmail && byRating && byHotelName
        } ?: emptyList()

        Log.d("FilterDebug", "Filtered reviews count: ${filteredReviews.size}")
        return filteredReviews
    }

    // Helper function to check if an age matches a given age range
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