package com.example.chainsearch.features.feature_introScreen.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class IntroScreenViewModel : ViewModel() {
    val _switchScreenFlow = MutableSharedFlow<Int>()
    val switchScreenFlow = _switchScreenFlow.asSharedFlow()

    fun onNavigate(event: Int) {
        viewModelScope.launch {
            _switchScreenFlow.emit(event)
        }
    }
}