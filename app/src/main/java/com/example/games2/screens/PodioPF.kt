package com.example.games2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.games2.components.cardsPodios
import com.example.games2.models.Pf
import com.example.games2.models.PfViewModel
import com.example.games2.navegation.Routes
import com.example.games2.ui.theme.Pixel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun PodioPF(navController: NavController, info: PfViewModel) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(top = 15.dp, bottom = 15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "PODIO",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    fontSize = 33.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = "PICAS Y FIJAS",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier.clickable { navController.navigate(Routes.Home.route) },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = null)
                        Text(text = "Home")
                    }
                    Column(
                        modifier = Modifier.clickable { navController.navigate(Routes.podioPopCat.route) },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.DragIndicator, contentDescription = null)
                        Text(text = "PopCat")
                    }
                }
            }
        }
    ) {

        var lista: MutableList<Pf> = mutableListOf()

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant)
                .padding(20.dp),

            horizontalArrangement = Arrangement.Center,
            columns = GridCells.Fixed(2)

        ) {

            for (ii in info.pf.value) {
                lista.add(ii)
            }
            lista.sortByDescending { it.recor }

            items(lista) { ss ->
                cardsPodios(ss.nom, ss.recor.toString(),  160, 200)
            }
        }
    }
}