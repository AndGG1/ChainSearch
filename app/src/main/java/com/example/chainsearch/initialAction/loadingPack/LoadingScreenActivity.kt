package com.example.chainsearch.initialAction.loadingPack

import com.example.chainsearch.R
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoadingScreenActivity : ComponentActivity() {

    private var keepSplash = true
    private val viewModel: LoadingScreenViewModel = LoadingScreenViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplash }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        lifecycleScope.launch {
            delay(900)
            withContext(Dispatchers.IO) {
                viewModel.checkInternalData(window.decorView.rootView)
                viewModel.checkExternalData(this@LoadingScreenActivity, 1.0)
            }
            keepSplash = false
        }
    }
}
