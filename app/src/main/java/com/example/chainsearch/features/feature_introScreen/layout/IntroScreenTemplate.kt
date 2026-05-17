package com.example.chainsearch.features.feature_introScreen.layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chainsearch.R
import com.example.chainsearch.features.feature_introScreen.helpers.layoutHelpers.FontConfig
import com.example.chainsearch.features.feature_introScreen.helpers.layoutHelpers.rememberTransparentButtonColors
import com.example.chainsearch.features.feature_introScreen.helpers.viewModelHelpers.IntroEvent
import com.example.chainsearch.features.feature_introScreen.viewModels.IntroScreenViewModel
import com.example.chainsearch.features.feature_register.presentation.helpers.ViewModelHelpers.RegisterEvent
import com.example.chainsearch.features.feature_register.presentation.layout.SignUpTemplate
import com.example.chainsearch.features.feature_register.presentation.viewModels.RegisterViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Screen(
    regViewModel: RegisterViewModel?,
    logInViewModel: Any?,
    initialState: Int
) {
    var switchTo by remember { mutableStateOf(initialState) }
    val introEvents = IntroEvent()

    val eventFlow = if (regViewModel != null) regViewModel.screenEvent else null
    LaunchedEffect(eventFlow) {
        eventFlow?.collect { event ->
            switchTo = event
        }
    }

    AnimatedContent(
        targetState = switchTo,
        transitionSpec = {
            fadeIn(animationSpec = tween(300)) +
                    slideInVertically(
                        animationSpec = tween(400),
                        initialOffsetY = { fullHeight -> fullHeight }
                    ) with fadeOut(animationSpec = tween(300))
        },
        label = "ScreenNavigationAnimation"
    ) { targetState ->
        when (targetState) {
            introEvents.switchToRegister -> {
                SignUpTemplate(regViewModel!!)
            }

            introEvents.switchToLogIn -> {
                //todo
            }

            introEvents.switchToMainScreen -> {
                //todo
            }

            else -> {
                LoadingScreenTemplate()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroScreenTemplate() {
    val orange: Color = Color(204, 106, 20, 255)
    val lightOrange1: Color = Color(251, 237, 216, 255)

    val viewModel = IntroScreenViewModel()
    val registerViewModel = RegisterViewModel()
    //todo ins. logInViewModel

    var isEnabled by remember { mutableStateOf(true) }
    var switchTo by remember { mutableStateOf(0) }
    val introEvents = IntroEvent()
    val scope = rememberCoroutineScope()

    when (switchTo) {
        introEvents.switchToRegister -> {
            Screen(registerViewModel, null, RegisterEvent().NavigateBack)
        }
        introEvents.switchToLogIn -> {
            //todo: switch for log in screen
        }
    }

    LaunchedEffect(Unit) {
        viewModel.switchScreenFlow.collect {event ->
            switchTo = event
        }
    }

    if (switchTo == 0) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(R.drawable.introduction_background),
                    contentScale = ContentScale.Crop
                ),
            color = Color.Transparent
        ) {
            RowConfig {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    drawCircle(
                        color = Color(255, 166, 77, 255),
                        radius = size.height / 2f,
                        center = Offset(size.width / 2f, size.height / 1.15f)
                    )
                }
            }

            ColumnConfig {
                RowConfig {
                    TextConfig(
                        "Welcome to",
                        -460,
                        FontConfig(30, FontWeight.ExtraBold, null)
                    )
                }
            }
        }

        ColumnConfig {
            RowConfig {
                TextConfig(
                    "Versatile!",
                    -420,
                    FontConfig(30, null, FontStyle.Italic)
                )
            }
        }

        ColumnConfig {
            RowConfig {
                Text(
                    text = "_",
                    modifier = Modifier
                        .offset(x = (-50).dp, y = (-415).dp),
                    style = TextStyle(fontSize = 30.sp, fontStyle = FontStyle.Italic),
                    color = Color(251, 237, 216, 255)
                )
            }
        }

        ColumnConfig {
            RowConfig {
                TextConfig(
                    "Search products faster, find what you need.",
                    -330,
                    FontConfig(20, null, FontStyle.Italic)
                )
            }
        }

        ColumnConfig2 {
            CompositionLocalProvider(LocalRippleConfiguration provides null) {
                Button(
                    onClick = {
                        scope.launch {
                            viewModel.onNavigate(IntroEvent().switchToRegister)

                            delay(1500)
                            isEnabled = true
                        }
                    },
                    enabled = isEnabled,
                    colors = rememberTransparentButtonColors(),
                    modifier =
                        Modifier
                            .background(color = Color.Transparent)
                            .scale(1.35F)
                            .offset(x = (-75).dp)
                )
                {
                    Text(
                        text = "Sign Up",
                        color = lightOrange1,
                        modifier = Modifier
                            .background(
                                color = orange,
                                shape = RoundedCornerShape(50)
                            )
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }

        ColumnConfig2 {
            CompositionLocalProvider(LocalRippleConfiguration provides null) {
                Button(
                    onClick = {
                        scope.launch {
                            //todo: switch to log in screen

                            delay(1500)
                            isEnabled = true
                        }
                    },
                    enabled = isEnabled,
                    colors = rememberTransparentButtonColors(),
                    modifier =
                        Modifier
                            .background(color = Color.Transparent)
                            .scale(1.35F)
                            .offset(x = 75.dp)
                )
                {
                    Text(
                        text = "Log In",
                        color = lightOrange1,
                        modifier = Modifier
                            .background(
                                color = orange,
                                shape = RoundedCornerShape(50)
                            )
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }
    }

@Composable
fun ColumnConfig(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Composable
fun ColumnConfig2(content: @Composable ColumnScope.() -> Unit) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 700.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}

@Composable
fun RowConfig(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxHeight(),
        verticalAlignment = Alignment.Bottom
    ) {
        content()
    }
}

@Composable
fun TextConfig(text: String, y: Int, fontConfig: FontConfig) {
    Text(
        text = text,
        modifier = Modifier
            .offset(y = y.dp),
        style = TextStyle(fontSize = fontConfig.fontSize!!.sp, fontWeight = fontConfig.fontWeight),
        color = Color(251, 237, 216, 255)
    )
}

@Composable
@Preview
fun Preview3() {
    IntroScreenTemplate()
}
