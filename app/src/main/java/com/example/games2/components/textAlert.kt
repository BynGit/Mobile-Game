package com.example.games2.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun textAlert(texto:String) {
    Text(
        text = texto,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
}