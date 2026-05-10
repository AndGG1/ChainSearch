package com.example.chainsearch.feature_register.domain.use_cases

import android.content.Context
import com.example.chainsearch.feature_register.data.data_source.helpers.callbacks.IsValidCallback
import com.example.chainsearch.feature_register.domain.repository.RegisterRepository

class RegisterGoogleUserUseCase(private val repository: RegisterRepository) {

    operator fun invoke(context: Context, username: String, callback: IsValidCallback) {
        repository.registerWithGoogleEmail(
            context,
            username,
            callback
        )
    }
}