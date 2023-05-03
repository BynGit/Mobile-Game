package com.example.games2.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.games2.ui.theme.Pixel

@Composable
fun marcadorPF(picas:String, fijas:String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "P: $picas",
            color = Color.Black,
            fontSize = 90.sp,
            fontFamily = Pixel,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "F: $fijas",
            color = Color.Black,
            fontSize = 90.sp,
            fontFamily = Pixel,
            fontWeight = FontWeight.Normal
        )
    }
}