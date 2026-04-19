package com.example.chainsearch.initialAction.loadingPack.Templates

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
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
import com.example.chainsearch.initialAction.viewModels.LoadingScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun IntroScreenTemplate(viewModel: LoadingScreenViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(R.drawable.introduction_background),
                contentScale = ContentScale.Crop
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
            ) {
                drawCircle(
                    color = Color(255, 166, 77, 255),
                    radius = size.height / 2f,
                    center = Offset(size.width / 2f, size.height / 1.15f)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Welcome to",
                    modifier = Modifier
                        .offset(y = (-460).dp),
                    style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.ExtraBold),
                    color = Color(251, 237, 216, 255)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Versatile!",
                    modifier = Modifier
                        .offset(y = (-420).dp),
                    style = TextStyle(fontSize = 30.sp, fontStyle = FontStyle.Italic),
                    color = Color(251, 237, 216, 255)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "_",
                    modifier = Modifier
                        .offset(x = (-50).dp, y = (-415).dp),
                    style = TextStyle(fontSize = 30.sp, fontStyle = FontStyle.Italic),
                    color = Color(251, 237, 216, 255)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Search products faster, find what you need.",
                    modifier = Modifier
                        .offset(y = (-330).dp),
                    style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic),
                    color = Color(251, 237, 216, 255)
                )
            }
        }

        val orange: Color = Color(204, 106, 20, 255)
        val lightOrange1: Color = Color(251, 237, 216, 255)

        var isEnabled by remember { mutableStateOf(true) }
        val scope = rememberCoroutineScope()

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                scope.launch {
                    viewModel.setNewVal(3)
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
                        .scale(1.35F)
                        .offset(x = (-75).dp))
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

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    scope.launch {
                        viewModel.setNewVal(4)
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

@Composable
@Preview
fun Preview3() {
    IntroScreenTemplate(LoadingScreenViewModel())
}
