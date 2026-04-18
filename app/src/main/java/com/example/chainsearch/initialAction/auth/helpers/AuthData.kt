package com.example.chainsearch.initialAction.auth.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

data class AuthData(
    val username: String,
    var uid: String?,
    val databaseRef: DatabaseReference,
    val mAuth: FirebaseAuth
)
