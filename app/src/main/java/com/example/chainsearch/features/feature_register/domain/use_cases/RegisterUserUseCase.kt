package com.example.chainsearch.features.feature_register.domain.use_cases

import com.example.chainsearch.common.data.callbacks.IsValidCallback
import com.example.chainsearch.features.feature_register.domain.repository.RegisterRepository
import com.example.chainsearch.features.feature_register.presentation.helpers.ViewModelHelpers.UserConfig

class RegisterUserUseCase(private val repository: RegisterRepository) {

    operator fun invoke(userConfig: UserConfig, callback: IsValidCallback) {
        repository.registerWithEmail(
            userConfig.username,
            userConfig.password,
            userConfig.email,
            callback
        )
    }
}