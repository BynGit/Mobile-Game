package com.example.games2.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.games2.ui.theme.Pixel

@Composable
fun victoryPF(onClick:()-> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick() }
            .background(MaterialTheme.colors.primaryVariant)
            .padding(23.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(
                text = "Felicitaciones",
                fontFamily = Pixel,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 33.sp,
                textAlign = TextAlign.Center,
            )
        }

        item {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
                Text(
                    text = "+1", fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 43.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
        item {
            Text(text = "Acabaste de adivinar el número, ahora da CLICK en la estrella para continuar con el siguiente nivel.",
                textAlign = TextAlign.Center,
                color = Color.Black)
        }
    }
}