package com.example.comftyaccess.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.comftyaccess.MyApplication
import com.example.comftyaccess.model.Review



@Database(entities = [Review::class], version = 1, exportSchema = false)
abstract class AppLocalDBRepository : RoomDatabase() {
    abstract fun reviewDao(): ReviewDao
}

object AppLocalDB {
    val appLocalDBRepository by lazy {
        val context = MyApplication.getMyContext()
        Room.databaseBuilder(
            context,
            AppLocalDBRepository::class.java,
            "comftyAccessdb5.db"
        ).fallbackToDestructiveMigration().build()
    }
}