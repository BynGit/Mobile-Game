package com.example.games2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.games2.models.MainViewModel
import com.example.games2.ui.theme.Pixel
import com.example.games2.ui.theme.Shapes

@Composable
fun Login(
    isLoading:Boolean,
    statusNav:Boolean,
    onLoginClick: () -> Unit,
    MainviewModel: MainViewModel,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Text(
            text = "games",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = Pixel,
            fontSize = 79.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground
        ) }

        item {
            Icon(imageVector = Icons.Default.SportsEsports, contentDescription = null, modifier = Modifier.size(400.dp))
        }
        item{

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(50.dp))
            } else {
                Text(
                    text = "Ingresa con Google",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 22.sp),
                    fontWeight = FontWeight.Bold,
                    fontFamily = Pixel,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(6.dp, MaterialTheme.colors.onBackground, Shapes.small)
                        .padding(all = 13.dp)
                        .clickable { onLoginClick() }
                )
            }
        }



    }


}