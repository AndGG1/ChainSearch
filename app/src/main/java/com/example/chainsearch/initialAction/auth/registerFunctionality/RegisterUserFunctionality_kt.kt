package com.example.chainsearch.initialAction.auth.registerFunctionality

import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel
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

fun callRegisterEmail(username: String, password: String, email: String, viewModel: LoadingScreenViewModel) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(350)

        val registerAuthService =
            RegisterAuthService(
                mAuth,
                databaseRef
            )
        registerAuthService.registerEmail(email, password, username) { isValid, _ ->
            if (!isValid) {
                viewModel.setNewVal(3)
            } else {
                //TODO: Change to new window
            }
        }
    }
}
