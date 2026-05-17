package com.example.chainsearch.features.feature_logIn.data.data_source.BasicLogIn

import com.example.chainsearch.common.data.callbacks.IsValidCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val mAuth = FirebaseAuth.getInstance()
private val databaseRef = FirebaseDatabase.getInstance(
    "https://versatile-bf2d4-default-rtdb.europe-west1.firebasedatabase.app/"
).reference

fun callLogInEmail(email: String, password: String, callback: IsValidCallback) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(350)

        val logInAuthService =
            LogInAuthService(
                mAuth,
                databaseRef
            )
        logInAuthService.logInWithEmail(email, password, callback)
    }
}