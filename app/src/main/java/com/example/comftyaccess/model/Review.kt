package com.example.comftyaccess.model

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.comftyaccess.MyApplication
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import java.util.*

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey(autoGenerate = true) val reviewId: Int = 0,
    var hotelName: String,
    var email: String,
    var rate: Int,
    var age: Int,
    var accessNeed: String,
    var img: String,
    var description: String,
    var lastUpdated: Long? = null
) {
    init {
        email = email.lowercase(Locale.getDefault()) // Normalize the email to lowercase
    }

    fun validate() {
        if (rate !in 1..5) throw IllegalArgumentException("Rate must be between 1 and 5")
        if (age < 18) throw IllegalArgumentException("Age must be 18 or older")
        if (description.isEmpty()) throw IllegalArgumentException("Description cannot be empty")
    }
    companion object {
        const val REVIEW_ID = "reviewId"
        const val HOTEL_NAME = "hotelName"
        const val EMAIL = "email"
        const val RATE = "rate"
        const val AGE = "age"
        const val ACCESS_NEED = "accessNeed"
        const val IMG = "img"
        const val DESCRIPTION = "description"
        const val COLLECTION = "reviews"
        const val LAST_UPDATED = "lastUpdated"
        const val LOCAL_LAST_UPDATED = "reviews_local_last_update"


        fun fromJson(json: Map<String, Any>): Review {
            val reviewId = (json[REVIEW_ID] as Number).toInt()
            val hotelName = json[HOTEL_NAME] as String
            val email = json[EMAIL] as String
            val rate = (json[RATE] as Number).toInt()
            val age = (json[AGE] as Number).toInt()
            val accessNeed = json[ACCESS_NEED] as String
            val img = json[IMG] as String
            val description = json[DESCRIPTION] as String
            val lastUpdated = (json[LAST_UPDATED] as Timestamp?)?.seconds
            return Review(reviewId, hotelName, email, rate, age, accessNeed, img, description, lastUpdated)
        }
        fun getLocalLastUpdate(): Long {
            val sharedPref = MyApplication.getMyContext().getSharedPreferences("TAG", Context.MODE_PRIVATE)
            return sharedPref.getLong(LOCAL_LAST_UPDATED, 0)
        }

        fun setLocalLastUpdate( time: Long) {
            val sharedPref = MyApplication.getMyContext().getSharedPreferences("TAG", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putLong(LOCAL_LAST_UPDATED, time)
                commit()
            }
        }
    }
        fun toJson(): Map<String, Any> = hashMapOf(
            REVIEW_ID to reviewId,
            HOTEL_NAME to hotelName,
            EMAIL to email.lowercase(Locale.getDefault()), // Ensures email is always stored in lowercase
            RATE to rate,
            AGE to age,
            ACCESS_NEED to accessNeed,
            IMG to img,
            DESCRIPTION to description,
            LAST_UPDATED to FieldValue.serverTimestamp()
        )


}