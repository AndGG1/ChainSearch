package com.example.chainsearch.initialAction.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.chainsearch.initialAction.loadingPack.LoadingChecks
import com.example.chainsearch.initialAction.viewModels.states.ExternalListener
import com.example.chainsearch.initialAction.viewModels.states.InternalListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoadingScreenViewModel : ViewModel() {
    private val _activityDrawnState = MutableStateFlow<Int>(1)
    val activityDrawnState: StateFlow<Int> = _activityDrawnState

    var externalListener: ExternalListener? = null
    var internalListener: InternalListener? = null

    fun setNewVal(n: Int) {
        _activityDrawnState.value = n
    }

    fun checkExternalInternalData(context: Context, p: Double) {
        externalListener = LoadingChecks.checkExteriorEnv(context, p)
        internalListener = LoadingChecks.checkInternalEnv()
    }
}