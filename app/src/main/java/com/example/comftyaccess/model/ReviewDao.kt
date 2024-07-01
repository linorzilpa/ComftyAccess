package com.example.comftyaccess.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ReviewDao {
    @Query("SELECT * FROM reviews")
    fun getAllReviews(): LiveData<List<Review>>

    @Query("select * from reviews where reviewId = :reviewId")
    fun getReviewById(reviewId: Int): Review

    //onConflict= if the review is already exist with the same id, it will update it.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg reviews: Review)
}