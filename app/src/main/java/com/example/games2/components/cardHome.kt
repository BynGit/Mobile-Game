package com.example.games2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.games2.ui.theme.Pixel
import com.example.games2.ui.theme.Shapes

@Composable
fun CardHome(ti:String, texto:String) {

    var text1 by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .border(2.dp, MaterialTheme.colors.onBackground, Shapes.large)
            .padding(all = 20.dp)
            .clickable { text1 = !text1 },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = ti,
            fontFamily = Pixel,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 0.dp)
        )
        Text(
            textAlign = TextAlign.Justify,
            text = texto,
            maxLines = if (!text1) 3 else Int.MAX_VALUE
        )

    }
}