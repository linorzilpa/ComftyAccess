package com.example.comftyaccess.model

import android.graphics.Bitmap
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

class FireBaseModel {
    private val db = FirebaseFirestore.getInstance().apply {
        firestoreSettings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(false)
            .build()
    }
    private val storage = FirebaseStorage.getInstance()

    fun getAllReviewsSince(since: Long, callback: Model.Listener<List<Review>>) {
        db.collection(Review.COLLECTION)
            .whereGreaterThanOrEqualTo(Review.LAST_UPDATED, Timestamp(since, 0))
            .get()
            .addOnCompleteListener { task ->
                val list = mutableListOf<Review>()
                if (task.isSuccessful) {
                    for (json in task.result!!) {
                        val review = Review.fromJson(json.data)
                        list.add(review)
                    }
                }
                callback.onComplete(list)
            }
    }

    fun addReview(review: Review, listener: Model.ListenerVoid) {
        db.collection(Review.COLLECTION).document(review.reviewId.toString()).set(review.toJson())
            .addOnCompleteListener {
                listener.onComplete()
            }
    }

    fun getAllUsers(callback: Model.Listener<List<User>>) {
        db.collection(User.COLLECTION).get().addOnCompleteListener { task ->
            val list = mutableListOf<User>()
            if (task.isSuccessful) {
                for (json in task.result!!) {
                    val user = User.fromJson(json.data)
                    list.add(user)
                }
            }
            callback.onComplete(list)
        }
    }

    fun addUser(user: User, listener: Model.ListenerVoid) {
        db.collection(User.COLLECTION).document(user.email).set(user.toJson())
            .addOnCompleteListener {
                listener.onComplete()
            }
    }

    fun uploadImage(name: String, bitmap: Bitmap, listener: Model.Listener<String>) {
        val storageRef = storage.getReference()
        val imagesRef = storageRef.child("images/$name.jpg")
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()
        val uploadTask = imagesRef.putBytes(data)
        uploadTask.addOnFailureListener { listener.onComplete(null) }.addOnSuccessListener {
            imagesRef.getDownloadUrl()
                .addOnSuccessListener { uri -> listener.onComplete(uri.toString()) }
        }
    }


}