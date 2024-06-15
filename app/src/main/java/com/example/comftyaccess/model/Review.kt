package com.example.comftyaccess.model

class Review(
    reviewId: Int,
    hotelName: String,
    email: String,
    rate: Int,
    age: Int,
    accessNeed: String,
    img: String,
    description: String
) {
    var reviewId: Int = reviewId
        get() = field
        set(value) {
            field = value
        }

    var hotelName: String = hotelName
        get() = field
        set(value) {
            field = value
        }

    var email: String = email
        get() = field.lowercase() // Always return the email in lowercase
        set(value) {
            field = value.lowercase() // Store the email in lowercase
        }

    var rate: Int = rate
        get() = field
        set(value) {
            if (value !in 1..5) throw IllegalArgumentException("Rate must be between 1 and 5")
            field = value
        }

    var age: Int = age
        get() = field
        set(value) {
            if (value < 18) throw IllegalArgumentException("Age must be 18 or older")
            field = value
        }

    var accessNeed: String = accessNeed
        get() = field
        set(value) {
            field = value
        }

    var img: String = img
        get() = field
        set(value) {
            field = value
        }

    var description: String = description
        get() = field
        set(value) {
            if (value.isEmpty()) throw IllegalArgumentException("Description cannot be empty")
            field = value
        }

    init {
        println("Creating a complete review with ID $reviewId")
    }

    // Secondary constructor without reviewID
    constructor(
        hotelName: String,
        email: String,
        rate: Int,
        age: Int,
        accessNeed: String,
        img: String,
        description: String
    ) : this(0, hotelName, email, rate, age, accessNeed, img, description) {
        println("Creating a review without an explicit ID")
    }
}