package com.example.chainsearch.feature_register.presentation.helpers.LayoutHelpers

fun validateInputs(
    usernameReady: Boolean,
    emailReady: Boolean,
    passwordReady: Boolean
): String? {
    return when {
        !usernameReady -> "Username should be between 2 and 20 characters long!"
        !emailReady -> "Email should not be empty!"
        !passwordReady -> "Password should be between 4 and 16 characters long!"
        else -> null
    }
}
