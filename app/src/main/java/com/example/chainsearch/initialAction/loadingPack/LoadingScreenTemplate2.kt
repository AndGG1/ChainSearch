package com.example.chainsearch.initialAction.loadingPack

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
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

@Composable
fun LoadingScreenTemplate_2() {
    val orange: Color = Color(204, 106, 20, 255)
    val lightOrange1: Color = Color(251, 237, 216, 255)
    val lightOrange2: Color = Color(255, 212, 159, 255)
    val lightOrange3: Color = Color(255, 166, 77, 255)

    val transition = rememberInfiniteTransition()
    val anim = transition.animateFloat(
        initialValue = 5000F,
        targetValue = 7000F,
        animationSpec = infiniteRepeatable(
            animation = tween(1750),
            repeatMode = RepeatMode.Reverse
        )
    )
    val anim2 = transition.animateFloat(
        initialValue = 331F,
        targetValue = 333F,
        animationSpec = infiniteRepeatable(
            animation = tween(1250),
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
            .background(color = orange)
            .padding(9.dp)
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
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
        Box {
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
                        .offset(x = (-30).dp )
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
                    text = "  Authentication Info.  ",
                    modifier = Modifier
                        .padding(top = anim2.value.dp)
                        .clip(shape = RoundedCornerShape(6.dp, 6.dp, 6.dp, 6.dp))
                        .background(color = orange)
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
                        .padding(top = 560.dp),
                    style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic),
                    fontWeight = FontWeight(200)
                )
            }
        }

        var usernameScaleState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 250.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier
                    .scale(if (usernameScaleState.value) {1.82F} else 1.72F),
            )
        }
        UsernameTextLabel(usernameScaleState)

        var emailScaleState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 400.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier
                    .scale(if (emailScaleState.value) {1.82F} else 1.72F),
            )
        }
        EmailTextLabel(emailScaleState)

        var passwordState = remember { mutableStateOf(false) }
        Box(modifier = Modifier.padding(top = 500.dp, start = 70.dp)) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2),
                contentDescription = "Menu icon (vector)",
                modifier = Modifier
                    .scale(if (passwordState.value) {1.82F} else 1.72F),
            )
        }
        PasswordTextLabel(passwordState)
    }
}

@Composable
fun UsernameTextLabel(state: MutableState<Boolean>) {
    var username by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 228.dp)) {
        TextField(
            value = username,
            onValueChange = { username = it },
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
fun EmailTextLabel(state: MutableState<Boolean>) {
    var email by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 378.dp)) {
        TextField(
            value = email,
            onValueChange = { email = it },
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
fun PasswordTextLabel(state: MutableState<Boolean>) {
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.padding(top = 478.dp)) {
        TextField(
            value = password,
            onValueChange = { password = it },
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
@Preview
fun Preview2() {
    LoadingScreenTemplate_2()
}
