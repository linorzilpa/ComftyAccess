package com.example.comftyaccess

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class MainNavGraphDirections private constructor() {
  private data class ActionGlobalMyProfileFragment(
    public val email: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_global_myProfileFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("email", this.email)
        return result
      }
  }

  public companion object {
    public fun actionGlobalMyProfileFragment(email: String): NavDirections =
        ActionGlobalMyProfileFragment(email)

    public fun actionGlobalAllReviewsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_global_allReviewsFragment)

    public fun actionGlobalFilterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_global_filterFragment)

    public fun actionGlobalMapFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_global_mapFragment)

    public fun actionGlobalAddReviewFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_global_addReviewFragment)
  }
}
