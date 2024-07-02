package com.example.comftyaccess

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class AllReviewsFragmentDirections private constructor() {
  private data class ActionAllReviewsFragmentToEditReviewFragment(
    public val pos: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_allReviewsFragment_to_editReviewFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("pos", this.pos)
        return result
      }
  }

  public companion object {
    public fun actionAllReviewsFragmentToEditReviewFragment(pos: Int): NavDirections =
        ActionAllReviewsFragmentToEditReviewFragment(pos)

    public fun actionGlobalMyProfileFragment(email: String): NavDirections =
        MainNavGraphDirections.actionGlobalMyProfileFragment(email)

    public fun actionGlobalAllReviewsFragment(): NavDirections =
        MainNavGraphDirections.actionGlobalAllReviewsFragment()

    public fun actionGlobalFilterFragment(): NavDirections =
        MainNavGraphDirections.actionGlobalFilterFragment()

    public fun actionGlobalMapFragment(): NavDirections =
        MainNavGraphDirections.actionGlobalMapFragment()

    public fun actionGlobalAddReviewFragment(): NavDirections =
        MainNavGraphDirections.actionGlobalAddReviewFragment()
  }
}
