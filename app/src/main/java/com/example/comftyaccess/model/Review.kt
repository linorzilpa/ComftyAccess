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
    @PrimaryKey(autoGenerate = true) var reviewId: Int = 0,
    var hotelName: String,
    var email: String,
    var rate: Int,
    var age: Int,
    var accessNeed: String,
    var img: String,
    var description: String,
    var lastUpdated: Long? = null,
    var deleted: Boolean = false // New field to track deletion status
) {
    init {
        email = email.lowercase(Locale.getDefault()) // Normalize the email to lowercase
    }
    constructor(emailOfOwner: String, description: String, city: String, sport: String, img: String) :
            this(hotelName = city, email = emailOfOwner, rate = 1, age = 18, accessNeed = sport, img = img, description = description)

    // Secondary constructor for initialization with reviewId
    constructor(id: String, emailOfOwner: String, description: String, city: String, sport: String, img: String) :
            this(reviewId = id.toInt(), hotelName = city, email = emailOfOwner, rate = 1, age = 18, accessNeed = sport, img = img, description = description)

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
        const val DELETED = "deleted"

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
            val deleted = json[DELETED] as Boolean? ?: false // Handle deleted field
            return Review(reviewId, hotelName, email, rate, age, accessNeed, img, description, lastUpdated, deleted)
        }

        fun getLocalLastUpdate(): Long {
            val sharedPref = MyApplication.getMyContext().getSharedPreferences("TAG", Context.MODE_PRIVATE)
            return sharedPref.getLong(LOCAL_LAST_UPDATED, 0)
        }

        fun setLocalLastUpdate(time: Long) {
            val sharedPref = MyApplication.getMyContext().getSharedPreferences("TAG", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putLong(LOCAL_LAST_UPDATED, time)
                commit()
            }
        }
    }

    fun generateID() {
        reviewId = Model.instance.generateID(Model.instance.getAllReviews())
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
        LAST_UPDATED to FieldValue.serverTimestamp(),
        DELETED to deleted // Add deleted field to JSON
    )
}