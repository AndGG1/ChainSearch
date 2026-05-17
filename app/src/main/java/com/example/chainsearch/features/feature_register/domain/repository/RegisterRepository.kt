package com.example.chainsearch.features.feature_register.domain.repository

import android.content.Context
import com.example.chainsearch.common.data.callbacks.IsValidCallback

interface RegisterRepository {
    fun registerWithEmail(username: String, password: String, email: String, callback: IsValidCallback)

    fun registerWithGoogleEmail(context: Context, username: String, callback: IsValidCallback)
}