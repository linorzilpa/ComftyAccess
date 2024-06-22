package com.example.comftyaccess.model

import Review
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ReviewDao {
    @Query("select * from reviews")
    fun getAllReviews(): LiveData<List<Review>>

    @Query("select * from reviews where reviewId = :ReviewID")
    fun getReviewById(ReviewID: String?): Review?

    //onConflict= if the review is already exist with the same id, it will update it.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg recommendations: Review?)
}