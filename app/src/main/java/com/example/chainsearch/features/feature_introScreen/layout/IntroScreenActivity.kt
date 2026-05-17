package com.example.chainsearch.features.feature_introScreen.layout

import android.content.Intent
import android.os.Build
import com.example.chainsearch.R
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingScreenActivity : ComponentActivity() {
    private var keepSplash = true

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        startSplashScreen()

        lifecycleScope.launch {
            delay(500)
            keepSplash = false

            startActivity(Intent(this@LoadingScreenActivity, IntroScreenTemplateClass::class.java))
        }
    }

    private fun startSplashScreen() {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { keepSplash }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}

class IntroScreenTemplateClass : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroScreenTemplate()
        }
    }
}
