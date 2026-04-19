package com.example.chainsearch.initialAction.loadingPack.helpers

import android.content.Context
import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel

private const val percentageOfFreeSpace: Double = 1.5
fun switchActivity(viewModel: LoadingScreenViewModel, context: Context) {
    viewModel.checkExternalInternalData(
        context, percentageOfFreeSpace
    )
    viewModel.setNewVal(1)
}