package com.example.chainsearch.features.feature_register.presentation.uiState

import androidx.compose.runtime.MutableState

data class StatesManager(
    val state: MutableState<Boolean>,
    val isReady: MutableState<Boolean>,
    val value: MutableState<String>
)