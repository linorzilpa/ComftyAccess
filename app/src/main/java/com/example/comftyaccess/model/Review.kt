package com.example.comftyaccess.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey(autoGenerate = true) val reviewId: Int = 0,  // Auto-increment ID
    var hotelName: String,
    var email: String,
    var rate: Int,
    var age: Int,
    var accessNeed: String,
    var img: String,
    var description: String
) {
    init {
        email = email.lowercase() // Normalize the email to lowercase
    }

    fun validate() {
        if (rate !in 1..5) throw IllegalArgumentException("Rate must be between 1 and 5")
        if (age < 18) throw IllegalArgumentException("Age must be 18 or older")
        if (description.isEmpty()) throw IllegalArgumentException("Description cannot be empty")
    }
}