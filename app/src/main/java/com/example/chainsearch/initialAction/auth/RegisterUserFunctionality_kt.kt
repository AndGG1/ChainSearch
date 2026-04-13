package com.example.chainsearch.initialAction.auth

import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun callRegisterEmail(username: String, password: String, email: String, viewModel: LoadingScreenViewModel) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(150)
        RegisterUserFunctionality.registerEmail(email, password, username, {isValid, uid ->
            if (!isValid) {
                viewModel.setNewVal(true)
            }
        })
    }
}