package com.example.chainsearch.common.data.utils.functionality_utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.credentials.GetCredentialRequest
import com.example.chainsearch.BuildConfig
import com.example.chainsearch.utils.generateSaltKey
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption

@RequiresApi(Build.VERSION_CODES.O)
fun getCredentialRequest() : GetCredentialRequest {
    val googleCredentialOption =
        GetSignInWithGoogleOption.Builder(
            serverClientId = BuildConfig.WEB_ID)
            .setNonce(generateSaltKey(16))
            .build()

    return GetCredentialRequest(listOf(googleCredentialOption))
}
