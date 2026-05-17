package com.example.chainsearch.features.feature_register.presentation.helpers.ViewModelHelpers

data class RegisterEvent(
    val NavigateBack: Int = 1,
    val NavigateToLoadingScreen: Int = 2,
    val NavigateToMainScreen: Int = 3
)