package com.example.comftyaccess

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class SignUpFragmentDirections private constructor() {
  public companion object {
    public fun actionSignUpFragmentToSignInFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signUpFragment_to_signInFragment)
  }
}
