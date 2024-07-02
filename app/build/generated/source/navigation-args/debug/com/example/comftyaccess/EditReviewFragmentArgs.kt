package com.example.comftyaccess

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class EditReviewFragmentArgs(
  public val pos: Int
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("pos", this.pos)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("pos", this.pos)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): EditReviewFragmentArgs {
      bundle.setClassLoader(EditReviewFragmentArgs::class.java.classLoader)
      val __pos : Int
      if (bundle.containsKey("pos")) {
        __pos = bundle.getInt("pos")
      } else {
        throw IllegalArgumentException("Required argument \"pos\" is missing and does not have an android:defaultValue")
      }
      return EditReviewFragmentArgs(__pos)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EditReviewFragmentArgs {
      val __pos : Int?
      if (savedStateHandle.contains("pos")) {
        __pos = savedStateHandle["pos"]
        if (__pos == null) {
          throw IllegalArgumentException("Argument \"pos\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pos\" is missing and does not have an android:defaultValue")
      }
      return EditReviewFragmentArgs(__pos)
    }
  }
}
