package com.example.chainsearch.initialAction.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.chainsearch.initialAction.loadingPack.LoadingChecks
import com.example.chainsearch.initialAction.viewModels.states.ExternalListener
import com.example.chainsearch.initialAction.viewModels.states.InternalListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoadingScreenViewModel : ViewModel() {
    private val _activityDrawnState = MutableStateFlow<Boolean>(false)
    val activityDrawnState: StateFlow<Boolean> = _activityDrawnState

    private val _registerState = MutableStateFlow<Boolean>(false)
    val registerState: StateFlow<Boolean> = _registerState

    var externalListener: ExternalListener? = null
    var internalListener: InternalListener? = null

    private var username: String = ""
    private var password: String = ""
    private var email: String = ""

    fun setNewVal(b: Boolean) {
        _activityDrawnState.value = b
    }

    fun setRegState(b: Boolean) {
        _registerState.value = b
    }

    fun setUserData(u: String, p: String, e: String) {
        username = u
        password = p
        email = e
    }

    fun getUsername() : String{
        return username
    }

    fun getPassword() : String {
        return password
    }

    fun getEmail() : String {
        return email
    }

    fun checkExternalInternalData(context: Context, p: Double) {
        externalListener = LoadingChecks.checkExteriorEnv(context, p)
        internalListener = LoadingChecks.checkInternalEnv()
    }
}