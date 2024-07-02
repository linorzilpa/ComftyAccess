package com.example.comftyaccess.model

import android.graphics.Bitmap
import android.util.Log
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

class FireBaseModel {
    // Firestore instance with custom settings
    private val db = FirebaseFirestore.getInstance().apply {
        firestoreSettings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(false)
            .build()
    }

    // Firebase Storage instance
    private val storage = FirebaseStorage.getInstance()

    // Fetch all reviews updated since a given timestamp
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

    // Add a new review to the Firestore database
    fun addReview(review: Review, listener: Model.ListenerVoid) {
        db.collection(Review.COLLECTION).document(review.reviewId.toString()).set(review.toJson())
            .addOnCompleteListener {
                listener.onComplete()
            }
    }

    // Fetch all users from the Firestore database
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

    // Add a new user to the Firestore database
    fun addUser(user: User, listener: Model.ListenerVoid) {
        db.collection(User.COLLECTION).document(user.email).set(user.toJson())
            .addOnCompleteListener {
                listener.onComplete()
            }
    }

    // Upload an image to Firebase Storage and get its download URL
    fun uploadImage(name: String, bitmap: Bitmap, listener: Model.Listener<String>) {
        Log.d("FirebaseStorage1", "upload image")
        val storageRef = storage.reference
        val imagesRef = storageRef.child("images/$name.jpg")

        // Convert bitmap to byte array
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        // Start the image upload
        val uploadTask = imagesRef.putBytes(data)
        Log.d("FirebaseStorage1", "before uploading...")

        // Handle upload failure
        uploadTask.addOnFailureListener { exception ->
            Log.d("FirebaseStorage1", "upload image failed")
            Log.e("FirebaseStorage", "Getting download URL failed", exception)
            listener.onComplete(null)
        }
            // Handle upload success and get download URL
            .addOnSuccessListener {
                Log.d("FirebaseStorage1", "upload image success")
                imagesRef.downloadUrl
                    .addOnSuccessListener { uri -> listener.onComplete(uri.toString()) }
            }
        Log.d("FirebaseStorage1", "end of func")
    }
}