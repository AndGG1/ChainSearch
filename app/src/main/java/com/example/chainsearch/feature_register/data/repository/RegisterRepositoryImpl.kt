package com.example.chainsearch.feature_register.data.repository

import android.content.Context
import com.example.chainsearch.feature_register.data.data_source.basicRegistration.callRegisterEmail
import com.example.chainsearch.feature_register.data.data_source.googleRegistration.callRegisterWithGoogleEmail
import com.example.chainsearch.feature_register.data.data_source.helpers.callbacks.IsValidCallback
import com.example.chainsearch.feature_register.domain.repository.RegisterRepository

class RegisterRepositoryImpl : RegisterRepository {
    override fun registerWithEmail(
        username: String,
        password: String,
        email: String,
        callback: IsValidCallback
    ) {
        callRegisterEmail(username, password, email, callback)
    }

    override fun registerWithGoogleEmail(
        context: Context,
        username: String,
        callback: IsValidCallback
    ) {
        callRegisterWithGoogleEmail(context, username, callback)
    }
}