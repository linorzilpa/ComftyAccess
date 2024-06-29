package com.example.comftyaccess.model

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
}