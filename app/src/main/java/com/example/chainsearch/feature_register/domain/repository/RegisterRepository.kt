package com.example.chainsearch.feature_register.domain.repository

import android.content.Context
import com.example.chainsearch.feature_register.data.data_source.helpers.callbacks.IsValidCallback

interface RegisterRepository {
    fun registerWithEmail(username: String, password: String, email: String, callback: IsValidCallback)

    fun registerWithGoogleEmail(context: Context, username: String, callback: IsValidCallback)
}