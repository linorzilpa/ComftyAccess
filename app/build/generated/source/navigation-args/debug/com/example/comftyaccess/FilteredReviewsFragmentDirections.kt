package com.example.comftyaccess

import androidx.navigation.NavDirections
import kotlin.String

public class FilteredReviewsFragmentDirections private constructor() {
  public companion object {
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
