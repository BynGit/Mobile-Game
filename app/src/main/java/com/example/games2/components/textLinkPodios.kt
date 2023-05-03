package com.example.games2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.games2.ui.theme.Pixel
import com.example.games2.ui.theme.Shapes

@Composable
fun textLinksPodios(ti:String, funcion: () -> Unit) {
    Text(
        text = ti,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 15.sp,
            background = Color.Black,
            fontFamily = Pixel,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .background(Color.Black)
            .border(2.dp, MaterialTheme.colors.onBackground, Shapes.large)
            .padding(all = 6.dp)
            .clickable { funcion() }
    )
}