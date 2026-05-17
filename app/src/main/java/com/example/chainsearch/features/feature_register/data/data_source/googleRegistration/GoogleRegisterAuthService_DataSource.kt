package com.example.chainsearch.features.feature_register.data.data_source.googleRegistration

import android.content.Context
import com.example.chainsearch.common.data.callbacks.IsValidCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private val mAuth = FirebaseAuth.getInstance()
private val databaseRef = FirebaseDatabase.getInstance(
    "https://versatile-bf2d4-default-rtdb.europe-west1.firebasedatabase.app/"
).reference

fun callRegisterWithGoogleEmail(context: Context, username: String, callback: IsValidCallback) {
    CoroutineScope(Dispatchers.IO).launch {
        val service =
            GoogleRegisterAuthService(
                mAuth,
                databaseRef
            )
        service.registerUserWithGoogle(context, username, callback)
    }
}