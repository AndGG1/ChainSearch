package com.example.chainsearch.common.data.utils.data_utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

data class AuthData(
    val username: String,
    var uid: String?,
    val databaseRef: DatabaseReference,
    val mAuth: FirebaseAuth,
    val email: String
)
