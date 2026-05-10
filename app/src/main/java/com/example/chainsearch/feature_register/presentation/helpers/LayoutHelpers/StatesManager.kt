package com.example.chainsearch.feature_register.presentation.helpers.LayoutHelpers

import androidx.compose.runtime.MutableState

data class StatesManager(
    val state: MutableState<Boolean>,
    val isReady: MutableState<Boolean>,
    val value: MutableState<String>
)