package com.example.chainsearch.initialAction.loadingPack.helpers

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

data class FontConfig(
    val fontSize: Int? = 15,
    val fontWeight: FontWeight? = FontWeight.Normal,
    val fontStyle: FontStyle? = FontStyle.Normal
)

data class FieldConfig(
    val label: String,
    val topPadding: Int,
    val rectPadding: Int,
    val state: MutableState<Boolean>,
    val isReady: MutableState<Boolean>,
    val value: MutableState<String>,
    val minLength: Int = 1
)

data class ErrorConfig(
    val backgroundColor: Color = Color(215, 59, 59, 245),
    val textColor: Color = Color(239, 188, 188, 255),
    val iconTint: Color = Color.White
)

@Composable
fun rememberTransparentButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Color.Transparent,
    contentColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    disabledContentColor = Color.Transparent
)

@Composable
fun transparentTextFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    errorContainerColor = Color.Transparent
)