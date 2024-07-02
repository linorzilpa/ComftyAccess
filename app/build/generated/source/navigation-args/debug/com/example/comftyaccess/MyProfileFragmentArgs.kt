package com.example.comftyaccess

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class MyProfileFragmentArgs(
  public val email: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("email", this.email)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("email", this.email)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): MyProfileFragmentArgs {
      bundle.setClassLoader(MyProfileFragmentArgs::class.java.classLoader)
      val __email : String?
      if (bundle.containsKey("email")) {
        __email = bundle.getString("email")
        if (__email == null) {
          throw IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue")
      }
      return MyProfileFragmentArgs(__email)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MyProfileFragmentArgs {
      val __email : String?
      if (savedStateHandle.contains("email")) {
        __email = savedStateHandle["email"]
        if (__email == null) {
          throw IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"email\" is missing and does not have an android:defaultValue")
      }
      return MyProfileFragmentArgs(__email)
    }
  }
}
