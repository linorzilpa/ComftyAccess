package com.example.comftyaccess

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class FilteredReviewsFragmentArgs(
  public val email: String,
  public val accessNeedType: String,
  public val rating: String,
  public val ageRangeType: String,
  public val hotelName: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("email", this.email)
    result.putString("accessNeedType", this.accessNeedType)
    result.putString("rating", this.rating)
    result.putString("ageRangeType", this.ageRangeType)
    result.putString("hotelName", this.hotelName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("email", this.email)
    result.set("accessNeedType", this.accessNeedType)
    result.set("rating", this.rating)
    result.set("ageRangeType", this.ageRangeType)
    result.set("hotelName", this.hotelName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FilteredReviewsFragmentArgs {
      bundle.setClassLoader(FilteredReviewsFragmentArgs::class.java.classLoader)
      val __email : String?
      if (bundle.containsKey("email")) {
        __email = bundle.getString("email")
        if (__email == null) {
          throw IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue")
      }
      val __accessNeedType : String?
      if (bundle.containsKey("accessNeedType")) {
        __accessNeedType = bundle.getString("accessNeedType")
        if (__accessNeedType == null) {
          throw IllegalArgumentException("Argument \"accessNeedType\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"accessNeedType\" is missing and does not have an android:defaultValue")
      }
      val __rating : String?
      if (bundle.containsKey("rating")) {
        __rating = bundle.getString("rating")
        if (__rating == null) {
          throw IllegalArgumentException("Argument \"rating\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"rating\" is missing and does not have an android:defaultValue")
      }
      val __ageRangeType : String?
      if (bundle.containsKey("ageRangeType")) {
        __ageRangeType = bundle.getString("ageRangeType")
        if (__ageRangeType == null) {
          throw IllegalArgumentException("Argument \"ageRangeType\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"ageRangeType\" is missing and does not have an android:defaultValue")
      }
      val __hotelName : String?
      if (bundle.containsKey("hotelName")) {
        __hotelName = bundle.getString("hotelName")
        if (__hotelName == null) {
          throw IllegalArgumentException("Argument \"hotelName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"hotelName\" is missing and does not have an android:defaultValue")
      }
      return FilteredReviewsFragmentArgs(__email, __accessNeedType, __rating, __ageRangeType,
          __hotelName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        FilteredReviewsFragmentArgs {
      val __email : String?
      if (savedStateHandle.contains("email")) {
        __email = savedStateHandle["email"]
        if (__email == null) {
          throw IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue")
      }
      val __accessNeedType : String?
      if (savedStateHandle.contains("accessNeedType")) {
        __accessNeedType = savedStateHandle["accessNeedType"]
        if (__accessNeedType == null) {
          throw IllegalArgumentException("Argument \"accessNeedType\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"accessNeedType\" is missing and does not have an android:defaultValue")
      }
      val __rating : String?
      if (savedStateHandle.contains("rating")) {
        __rating = savedStateHandle["rating"]
        if (__rating == null) {
          throw IllegalArgumentException("Argument \"rating\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"rating\" is missing and does not have an android:defaultValue")
      }
      val __ageRangeType : String?
      if (savedStateHandle.contains("ageRangeType")) {
        __ageRangeType = savedStateHandle["ageRangeType"]
        if (__ageRangeType == null) {
          throw IllegalArgumentException("Argument \"ageRangeType\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"ageRangeType\" is missing and does not have an android:defaultValue")
      }
      val __hotelName : String?
      if (savedStateHandle.contains("hotelName")) {
        __hotelName = savedStateHandle["hotelName"]
        if (__hotelName == null) {
          throw IllegalArgumentException("Argument \"hotelName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"hotelName\" is missing and does not have an android:defaultValue")
      }
      return FilteredReviewsFragmentArgs(__email, __accessNeedType, __rating, __ageRangeType,
          __hotelName)
    }
  }
}
