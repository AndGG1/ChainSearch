package com.example.chainsearch.common.data.utils.functionality_utils

import androidx.credentials.GetCredentialResponse
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential

fun obtainToken(credentialObj: GetCredentialResponse): String {
    val googleIdTokenWrapped =
        GoogleIdTokenCredential.createFrom(credentialObj.credential.data)
    return googleIdTokenWrapped.idToken
}