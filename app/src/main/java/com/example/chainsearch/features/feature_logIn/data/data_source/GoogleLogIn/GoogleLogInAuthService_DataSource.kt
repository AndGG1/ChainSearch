package com.example.chainsearch.features.feature_logIn.data.data_source.GoogleLogIn

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

fun callLogInWithGoogleEmail(context: Context, username: String, callback: IsValidCallback) {
    CoroutineScope(Dispatchers.IO).launch {
        val service =
            GoogleLogInAuthService(
                mAuth,
                databaseRef
            )
        service.logInUserWithGoogle(context, username, callback)
    }
}