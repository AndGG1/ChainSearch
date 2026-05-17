package com.example.chainsearch.common.data.utils.functionality_utils

import android.os.Build
import com.example.chainsearch.common.data.callbacks.IsValidCallback
import com.example.chainsearch.common.data.utils.data_utils.AuthData
import com.example.chainsearch.common.data.utils.data_utils.User
import com.example.chainsearch.features.feature_logIn.data.data_source.helpers.callbacks.UsernameCallback
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import java.util.Calendar

fun isCallbackNull(callback : Any?) : Boolean {
    return callback == null
}

fun isBuildVersionValid() : Boolean {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.O
}

fun addNewUser(authData: AuthData, finalCallback: IsValidCallback) {
    val user: FirebaseUser? = authData.mAuth.currentUser
    if (user != null) {
        val uid = user.uid
        authData.uid = uid
        addUser(authData, finalCallback, null)
    } else {
        finalCallback.onRes(false, null)
    }
}

fun addUser(authData: AuthData, callback: IsValidCallback, user: User?) {
    val newUser = User(
        authData.username,
        Calendar.getInstance().time.toString(),
        0.0,
        0
    )

    authData.databaseRef.child("users")
        .child(authData.uid!!).setValue(user ?: newUser)
        .addOnCompleteListener(OnCompleteListener<Void?> { task: Task<Void?> ->
            callback.onRes(task.isSuccessful, authData.uid)
        })
}

fun obtainUsername(authData: AuthData, callback: UsernameCallback) {
    authData.databaseRef.child("users").child(authData.uid!!)
        .get().addOnCompleteListener({task ->
            if (task.isSuccessful) {
                val user = task.result.getValue(User::class.java)
                user!!.username?.let { callback.onRes(it) }
            } else {
                callback.onRes("")
            }
        })
}