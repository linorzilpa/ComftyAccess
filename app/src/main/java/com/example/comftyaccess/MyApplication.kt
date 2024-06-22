package com.example.comftyaccess

import android.app.Application
import android.content.Context


class MyApplication : Application() {
        companion object {
            private lateinit var context: Context

            fun getMyContext(): Context {
                return context
            }
        }

        override fun onCreate() {
            super.onCreate()
            context = applicationContext
        }
}