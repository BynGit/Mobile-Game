package com.example.games2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.games2.ui.theme.Pixel
import com.example.games2.ui.theme.Shapes

@Composable
fun cardsPodios(nom:String, record:String, w:Int, h:Int) {
    Column(
        modifier = Modifier
            .width(w.dp)
            .height(h.dp)
            .background(Color.Black)
            .border(2.dp, MaterialTheme.colors.onBackground, Shapes.large)
            .padding(all = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = nom,
            fontFamily = Pixel,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier.size(65.dp)
        )

        Text(
            text = record, fontFamily = Pixel,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
    }
}