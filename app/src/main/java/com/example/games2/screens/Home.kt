package com.example.games2.screens

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.games2.navegation.Routes
import com.example.games2.ui.theme.Pixel
import com.example.games2.ui.theme.Shapes
import com.example.games2.R
import com.example.games2.components.CardHome
import com.example.games2.components.textLinksPodios

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController, singout: () -> Unit, nombre: String, urlPhoto: String) {

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(top = 20.dp, bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    imageVector = Icons.Default.Extension,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clickable { navController.navigate(Routes.pf.route) }
                )
                Text(
                    text = "GAMES",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                )
                Icon(
                    imageVector = Icons.Default.CatchingPokemon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clickable { navController.navigate(Routes.popcat.route) }
                )
            }
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant)
                .padding(23.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(urlPhoto),
                            contentDescription = "photo_user",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                                .border(5.dp, Color.Black, CircleShape)
                        )
                        Text(
                            text = nombre,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = Pixel,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.width(175.dp)
                        )

                        Column(
                            modifier = Modifier
                                .width(157.dp)
                                .background(Color.Black)
                                .clickable {
                                    singout()

                                    Handler(Looper.getMainLooper()).postDelayed({

                                        navController.navigate(Routes.Login.route)

                                    }, 2000)
                                }
                                .border(1.dp, MaterialTheme.colors.onBackground, Shapes.large),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Logout,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        textLinksPodios(
                            ti = "Podio P y F"
                        ) {
                            navController.navigate(Routes.podioPF.route)
                        }

                        Spacer(
                            modifier = Modifier
                                .width(180.dp)
                                .height(3.dp)
                                .background(Color.Black)
                        )

                        textLinksPodios(
                            ti = "Podio Popcat"
                        ) {
                            navController.navigate(Routes.podioPopCat.route)
                        }


                    }
                }
            }



            item {
                Text(
                    text = "Instrucciones",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 0.dp)
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(Color.Black)
                )
            }


            item {
                CardHome(ti = "Picas y fijas", texto = stringResource(R.string.pf))
            }
            item {
                CardHome(ti = "Pop cat", texto = stringResource(R.string.popcat))
            }
        }
    }
}