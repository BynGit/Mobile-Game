package com.example.games2.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.games2.R
import com.example.games2.models.Pf
import com.example.games2.models.PopCat
import com.example.games2.navegation.Routes
import com.example.games2.ui.theme.Pixel
import com.example.games2.ui.theme.Shapes
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun uiForms(navController:NavController, record:String, nomBd:String, Pf:Boolean) {
    var nom by remember { mutableStateOf("") }
    var validar  by remember { mutableStateOf(false) }

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
                Text(
                    text = "Record SAVE",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                        .clickable { navController.navigate(Routes.Home.route) }
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
            verticalArrangement = Arrangement.SpaceEvenly

        ) {

            item {
                TextField(
                    value = nom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primaryVariant),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    onValueChange = { nom = it },
                    textStyle = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontFamily = Pixel,
                        fontWeight = FontWeight.Thin,
                        color = MaterialTheme.colors.onPrimary
                    )
                )
            }


            item {
                Row(
                    modifier = Modifier
                        .background(Color.Black)
                        .border(2.dp, MaterialTheme.colors.onBackground, Shapes.large)
                        .padding(all = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(65.dp)
                    )

                    Text(
                        text = record, fontFamily = Pixel,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                    )
                }
            }

            item {
                btnEnviar(funcion = {
                    if (nom == "") {
                        validar = true
                    } else {
                        if(Pf) {
                            val pf = Pf(nom = nom, recor = record.toInt())

                            Firebase.firestore.collection(nomBd).add(pf)

                            navController.navigate(Routes.podioPF.route)
                        }else {
                            val pf = PopCat(nombre = nom, record = record.toInt())

                            Firebase.firestore.collection(nomBd).add(pf)

                            navController.navigate(Routes.podioPopCat.route)
                        }
                    }
                })
            }

            if(validar) {
                item {
                    textAlert(texto = stringResource(R.string.alertForms))
                }
            }

        }
    }
}