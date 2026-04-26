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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chainsearch.R
import com.example.chainsearch.initialAction.auth.registerFunctionality.signInWithGoogle
import com.example.chainsearch.initialAction.auth.registerFunctionality.callRegisterEmail
import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTemplate(viewModel: LoadingScreenViewModel) {
    val currContext = LocalContext.current

    val orange: Color = Color(204, 106, 20, 255)
    val lightOrange1: Color = Color(251, 237, 216, 255)
    val lightOrange2: Color = Color(255, 212, 159, 255)
    val lightOrange3: Color = Color(255, 159, 56, 255)

    val usernameReady = remember { mutableStateOf(false) }
    val passwordReady = remember { mutableStateOf(false) }
    val emailReady = remember { mutableStateOf(false) }

    val usernameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }

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
            )
        ,color = Color.Transparent
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
                    center = Offset(size.width / 2f, size.height / 1.5f)
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
                text = "Sign up",
                modifier = Modifier.padding(start = 190.dp, top = 85.dp),
                style = TextStyle(fontSize = 25.sp),
                fontWeight = FontWeight(200)
            )

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "  User Info.  ",
                    modifier = Modifier
                        .padding(top = 230.dp)
                        .clip(shape = RoundedCornerShape(6.dp, 6.dp, 6.dp, 6.dp))
                        .background(color = lightOrange3)
                        .padding(3.dp)
                        .background(Color.White, RoundedCornerShape(6.dp)),
                    style = TextStyle(fontSize = 15.sp)
                )
            }

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "  Authentication Info.  ",
                    modifier = Modifier
                        .padding(top = 380.dp)
                        .clip(shape = RoundedCornerShape(6.dp, 6.dp, 6.dp, 6.dp))
                        .background(color = lightOrange3)
                        .padding(3.dp)
                        .background(Color.White, RoundedCornerShape(6.dp)),
                    style = TextStyle(fontSize = 15.sp)
                )
            }

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "~ or ~",
                    modifier = Modifier
                        .padding(top = 605.dp),
                    style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic),
                    fontWeight = FontWeight(200)
                )
            }

            var isEnabled by remember { mutableStateOf(true) }
            val scope = rememberCoroutineScope()
            Column (modifier = Modifier.fillMaxWidth().padding(top = 630.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                CompositionLocalProvider(LocalRippleConfiguration provides null) {
                    Button(
                        onClick = {
                            signInWithGoogle(currContext)

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
                        modifier =
                            Modifier
                                .background(color = Color.Transparent)
                    )
                    {
                        Text(
                            text = "       Sign up with Google  ",
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
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 644.dp)
                .offset(x = (-95).dp),  
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Menu icon (vector)",
                )
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 750.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                CompositionLocalProvider(LocalRippleConfiguration provides null) {
                    Button(
                        onClick = {
                            isEnabled = false
                            scope.launch {
                                delay(3000)
                                isEnabled = true
                            }

                            if (!usernameReady.value) {
                                errorM = "Username should be between 2 and 20 characters long!"
                                showError.value = true
                            } else if (!emailReady.value) {
                                errorM = "Email should not be empty!"
                                showError.value = true
                            } else if (!passwordReady.value) {
                                errorM = "Password should be between 4 and 16 characters long!"
                                showError.value = true
                            }

                            if (usernameReady.value && emailReady.value && passwordReady.value) {
                                viewModel.setNewVal(2)
                                callRegisterEmail(
                                    usernameValue.value,
                                    passwordValue.value,
                                    emailValue.value,
                                    viewModel
                                )
                            }
                        },
                        enabled = isEnabled,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.Transparent
                        ),
                        modifier =
                            Modifier
                                .background(color = Color.Transparent)
                                .scale(1.35F)
                    )
                    {
                        Text(
                            text = "Sign Up",
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
        }

        var usernameScaleState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 300.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier
                    .scale(if (usernameScaleState.value) {1.82F} else 1.72F),
            )
        }
        UsernameTextLabel(usernameScaleState, usernameReady, usernameValue)

        var emailScaleState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 450.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier
                    .scale(if (emailScaleState.value) {1.82F} else 1.72F),
            )
        }
        EmailTextLabel(emailScaleState, emailReady, emailValue)

        var passwordState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 550.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier
                    .scale(if (passwordState.value) {1.82F} else 1.72F),
            )
        }
        PasswordTextLabel(passwordState, passwordReady, passwordValue)
    }
}

@Composable
fun UsernameTextLabel(state: MutableState<Boolean>, isReady: MutableState<Boolean>, value: MutableState<String>) {
    var username by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(top = 278.dp)) {
        TextField(
            value = username,
            onValueChange = {
                username = it
                isReady.value = username.length >= 2
                value.value = username
                            },
            label = {Text("Username")},
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
fun EmailTextLabel(state: MutableState<Boolean>, isReady: MutableState<Boolean>, value: MutableState<String>) {
    var email by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 428.dp)) {
        TextField(
            value = email,
            onValueChange = {
                email = it
                isReady.value =
                    email.isNotEmpty() || email.isNotBlank()
                value.value = email
                            },
            label = {Text("Email")},
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
fun PasswordTextLabel(state: MutableState<Boolean>, isReady: MutableState<Boolean>, value: MutableState<String>) {
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 528.dp)) {
        TextField(
            value = password,
            onValueChange = {
                password = it
                isReady.value = password.length >= 4
                value.value = password
                            },
            label = {Text("Password")},
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
fun DisplayErrorMessage(
    errorMessage: String,
    onClose: () -> Unit,
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Box(
                modifier = Modifier
                    .background(
                        color = Color(215, 59, 59, 255).copy(.96f),
                        shape = RoundedCornerShape(50)
                    )
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {

                Text(
                    text = errorMessage + " ".repeat(6),
                    color = Color(239, 188, 188, 255),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )

                IconButton(
                    onClick = onClose,
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.TopEnd),
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color.White
                    )
                }
            }
        }
}

@Composable
@Preview
fun Preview2() {
    SignUpTemplate(LoadingScreenViewModel())
}
