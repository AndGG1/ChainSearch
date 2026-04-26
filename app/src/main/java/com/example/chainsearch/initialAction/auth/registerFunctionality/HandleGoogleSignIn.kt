package com.example.chainsearch.initialAction.auth.registerFunctionality

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private val mAuth = FirebaseAuth.getInstance()
private val databaseRef = FirebaseDatabase.getInstance(
    "https://versatile-bf2d4-default-rtdb.europe-west1.firebasedatabase.app/"
).reference

fun signInWithGoogle(context: Context) {
    CoroutineScope(Dispatchers.IO).launch {
        val service = GoogleRegisterAuthService(mAuth, databaseRef)
        service.registerUserWithGoogle(context)
    }
}