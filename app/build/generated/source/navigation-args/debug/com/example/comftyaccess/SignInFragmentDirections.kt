package com.example.comftyaccess

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class SignInFragmentDirections private constructor() {
  public companion object {
    public fun actionSignInFragmentToSignUpFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signInFragment_to_signUpFragment)
  }
}
