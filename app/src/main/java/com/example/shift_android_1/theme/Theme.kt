package com.example.shift_android_1.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

val Colors = lightColors(
    surface = shiftBackground,
    primary = shiftPrimary,
    onPrimary = shiftOnPrimary,
    background = shiftBackground
)

@Composable
fun SHIFTTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = Colors, content = content)
}