package com.example.chainsearch.initialAction.loadingPack.Templates

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chainsearch.R
//import com.example.chainsearch.initialAction.auth.loginFunctionality.callLoginEmail //todo
import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun LogInTemplate(viewModel: LoadingScreenViewModel) {
    val orange: Color = Color(204, 106, 20, 255)
    val lightOrange1: Color = Color(251, 237, 216, 255)
    val lightOrange2: Color = Color(255, 212, 159, 255)
    val lightOrange3: Color = Color(255, 159, 56, 255)

    val emailReady = remember { mutableStateOf(false) }
    val passwordReady = remember { mutableStateOf(false) }

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    var showError = remember { mutableStateOf(false) }
    var errorM by remember { mutableStateOf("") }

    val transition = rememberInfiniteTransition()
    val anim = transition.animateFloat(
        initialValue = 5000F,
        targetValue = 7000F,
        animationSpec = infiniteRepeatable(
            animation = tween(1750),
            repeatMode = RepeatMode.Reverse
        )
    )

    val animColor = transition.animateColor(
        initialValue = Color.White,
        targetValue = lightOrange2,
        animationSpec = infiniteRepeatable(
            animation = tween(3500),
            repeatMode = RepeatMode.Reverse
        )
    )
    val animColor2 = transition.animateColor(
        initialValue = lightOrange2,
        targetValue = Color.White,
        animationSpec = infiniteRepeatable(
            animation = tween(3500),
            repeatMode = RepeatMode.Reverse
        )
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    0.1f to animColor.value,
                    0.3f to animColor2.value,
                    startY = 0f,
                    endY = anim.value
                )
            ),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.Bottom
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(.25f)
            ) {
                drawCircle(
                    color = Color(255, 166, 77, 255),
                    radius = size.height / 2f,
                    center = Offset(size.width / 2f, size.height / 1.4f)
                )
            }
        }

        Box {
            if (showError.value) {
                DisplayErrorMessage(
                    errorM,
                    onClose = { showError.value = false },
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Versatile",
                    modifier = Modifier.padding(top = 40.dp),
                    style = TextStyle(fontSize = 40.sp),
                    fontWeight = FontWeight(200)
                )

                Text(
                    text = "_",
                    style = TextStyle(fontSize = 40.sp),
                    fontWeight = FontWeight(200),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .offset(x = (-63).dp, y = (-48).dp)
                )
            }

            Text(
                text = "Log in",
                modifier = Modifier.padding(start = 190.dp, top = 85.dp),
                style = TextStyle(fontSize = 25.sp),
                fontWeight = FontWeight(200)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "  Authentication Info.  ",
                    modifier = Modifier
                        .padding(top = 280.dp)
                        .clip(shape = RoundedCornerShape(6.dp, 6.dp, 6.dp, 6.dp))
                        .background(color = lightOrange3)
                        .padding(3.dp)
                        .background(Color.White, RoundedCornerShape(6.dp)),
                    style = TextStyle(fontSize = 15.sp)
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "~ or ~",
                    modifier = Modifier.padding(top = 510.dp),
                    style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic),
                    fontWeight = FontWeight(200)
                )
            }

            var isEnabled by remember { mutableStateOf(true) }
            var scope = rememberCoroutineScope()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 535.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        isEnabled = false
                        scope.launch {
                            delay(1500)
                            isEnabled = true
                        }
                    },
                    enabled = isEnabled,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    ),
                    modifier = Modifier.background(color = Color.Transparent)
                ) {
                    Text(
                        text = "       Log in with Google  ",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(6.dp, 6.dp, 6.dp, 6.dp))
                            .background(Color.White)
                            .padding(6.dp)
                            .background(Color.White),
                        color = Color.DarkGray,
                        style = TextStyle(fontSize = 20.sp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 549.dp)
                    .offset(x = (-95).dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Menu icon (vector)",
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 650.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        isEnabled = false
                        scope.launch {
                            delay(3000)
                            isEnabled = true
                        }

                        if (!emailReady.value) {
                            errorM = "Email should not be empty!"
                            showError.value = true
                        } else if (!passwordReady.value) {
                            errorM = "Password should be between 4 and 16 characters long!"
                            showError.value = true
                        }

                        if (emailReady.value && passwordReady.value) {
                            viewModel.setNewVal(2)
                   //         callLoginEmail(emailValue.value, passwordValue.value, viewModel) //TODO
                        }
                    },
                    enabled = isEnabled,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        disabledContentColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .scale(1.35F)
                ) {
                    Text(
                        text = "Log In",
                        color = lightOrange1,
                        modifier = Modifier
                            .background(
                                color = lightOrange3,
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

        var emailScaleState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 350.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier.scale(if (emailScaleState.value) 1.82F else 1.72F),
            )
        }
        LoginEmailTextLabel(emailScaleState, emailReady, emailValue)

        var passwordState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 450.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier.scale(if (passwordState.value) 1.82F else 1.72F),
            )
        }
        LoginPasswordTextLabel(passwordState, passwordReady, passwordValue)
    }
}

@Composable
fun LoginEmailTextLabel(state: MutableState<Boolean>, isReady: MutableState<Boolean>, value: MutableState<String>) {
    var email by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 328.dp)) {
        TextField(
            value = email,
            onValueChange = {
                email = it
                isReady.value = email.isNotEmpty() || email.isNotBlank()
                value.value = email
            },
            label = { Text("Email") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent
            ),
            modifier = Modifier.onFocusChanged { focusState ->
                state.value = focusState.isFocused
            }
        )
    }
}

@Composable
fun LoginPasswordTextLabel(state: MutableState<Boolean>, isReady: MutableState<Boolean>, value: MutableState<String>) {
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 428.dp)) {
        TextField(
            value = password,
            onValueChange = {
                password = it
                isReady.value = password.length >= 4
                value.value = password
            },
            label = { Text("Password") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent
            ),
            modifier = Modifier.onFocusChanged { focusState ->
                state.value = focusState.isFocused
            }
        )
    }
}

@Composable
@Preview
fun PreviewLogIn() {
    LogInTemplate(LoadingScreenViewModel())
}