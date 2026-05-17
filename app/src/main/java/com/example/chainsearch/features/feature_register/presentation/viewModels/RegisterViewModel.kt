package com.example.chainsearch.features.feature_register.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chainsearch.common.data.callbacks.IsValidCallback
import com.example.chainsearch.features.feature_register.data.repository.RegisterRepositoryImpl
import com.example.chainsearch.features.feature_register.domain.use_cases.RegisterGoogleUserUseCase
import com.example.chainsearch.features.feature_register.domain.use_cases.RegisterUserUseCase
import com.example.chainsearch.features.feature_register.presentation.helpers.ViewModelHelpers.UserConfig
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val repository = RegisterRepositoryImpl()

    private val _screenEvent = MutableSharedFlow<Int>()
    val screenEvent = _screenEvent.asSharedFlow()

    private val _registerMethod = MutableSharedFlow<Int>(0)
    val registerMethod = _registerMethod.asSharedFlow()

    private val _initialErrorM = MutableStateFlow<String>("")
    val inititalErrorM = _initialErrorM.asStateFlow()

    fun onNavigate(event: Int) {
        viewModelScope.launch {
            _screenEvent.emit(event)
        }
    }

    fun onRegister(regMethod: Int) {
        viewModelScope.launch {
            _registerMethod.emit(regMethod)
        }
    }

    fun registerWithEmail(userConfig: UserConfig, callback: IsValidCallback) {
        RegisterUserUseCase(repository).invoke(userConfig, callback)
    }

    fun registerWithGoogle(context: Context, username: String, callback: IsValidCallback) {
        RegisterGoogleUserUseCase(repository).invoke(context, username, callback)
    }

    fun writeErrorMessage(message: String) {
        _initialErrorM.value = message
    }
}