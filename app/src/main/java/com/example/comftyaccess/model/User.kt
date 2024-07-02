package com.example.comftyaccess.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import java.util.*

data class User(
    var name: String = "",
    var email: String = "",
    var age: Int = 0,
    var accessNeed: String = "",
    var img: String = "",
    var lastUpdated: Long? = null
) {
    init {
        email = email.lowercase(Locale.getDefault()) // Normalize the email to lowercase
    }

    companion object {
        const val NAME = "name"
        const val EMAIL = "email"
        const val AGE = "age"
        const val ACCESS_NEED = "accessNeed"
        const val IMG = "img"
        const val COLLECTION = "users"
        const val LAST_UPDATED = "lastUpdated"

        fun fromJson(json: Map<String, Any>): User {
            val email = json[EMAIL] as String
            val name = json[NAME] as String
            val age = (json[AGE] as Number).toInt()
            val accessNeed = json[ACCESS_NEED] as String
            val img = json[IMG] as String
            val lastUpdated = (json[LAST_UPDATED] as Timestamp?)?.seconds
            return User(name, email, age, accessNeed, img, lastUpdated)
        }
    }

    fun toJson(): Map<String, Any> {
        val json = mutableMapOf<String, Any>(
            NAME to name,
            EMAIL to email,
            AGE to age,
            ACCESS_NEED to accessNeed,
            IMG to img,
            LAST_UPDATED to FieldValue.serverTimestamp()
        )
        return json
    }

}