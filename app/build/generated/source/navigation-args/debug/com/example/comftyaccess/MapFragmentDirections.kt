package com.example.comftyaccess

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class MapFragmentDirections private constructor() {
  private data class ActionMapFragmentToFilteredReviewsFragment(
    public val email: String,
    public val accessNeedType: String,
    public val rating: String,
    public val ageRangeType: String,
    public val hotelName: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_mapFragment_to_filteredReviewsFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("email", this.email)
        result.putString("accessNeedType", this.accessNeedType)
        result.putString("rating", this.rating)
        result.putString("ageRangeType", this.ageRangeType)
        result.putString("hotelName", this.hotelName)
        return result
      }
  }

  public companion object {
    public fun actionMapFragmentToFilteredReviewsFragment(
      email: String,
      accessNeedType: String,
      rating: String,
      ageRangeType: String,
      hotelName: String
    ): NavDirections = ActionMapFragmentToFilteredReviewsFragment(email, accessNeedType, rating,
        ageRangeType, hotelName)

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
