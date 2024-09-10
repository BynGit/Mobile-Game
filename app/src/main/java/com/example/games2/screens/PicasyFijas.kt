package com.example.games2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.example.games2.components.btnEnviar
import com.example.games2.components.marcadorPF
import com.example.games2.components.textAlert
import com.example.games2.components.victoryPF
import com.example.games2.navegation.Routes
import com.example.games2.ui.theme.Pixel
import kotlin.random.Random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun PicasYFijas(navController: NavController) {

    fun generarNumerosSinRepeticion(cantidad: Int): List<Int> {
        val numeros = mutableListOf<Int>()
        val numerosGenerados = HashSet<Int>()

        while (numeros.size < cantidad) {
            var numero = Random.nextInt(1000, 10000)
            val digitos = numero.toString().toSet()
            if (digitos.size == 4) {
                numerosGenerados.add(numero)
                numeros.add(numero)
            }
        }

        return numeros
    }


    var numUser: String by remember { mutableStateOf("") }
    var victoria by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf(false) }

    var statusList by remember { mutableStateOf(false) }
    var lista = mutableListOf<Int>()
    var puntaje = 0


    var error by remember { mutableStateOf(false) }
    var fijas by remember { mutableStateOf(0) }
    var picas by remember { mutableStateOf(0) }

    var numero = generarNumerosSinRepeticion(5)
    var count = 0
    var count2 = 0


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
                    text = "PICAS Y FIJAS",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    fontSize = 33.sp,
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
                        modifier = Modifier.clickable { navController.navigate(Routes.popcat.route) },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.CatchingPokemon, contentDescription = null)
                        Text(text = "PopCat")
                    }
                }
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
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(3.dp, Color.Black)
                ) {
                    item {
                        if (!statusList) {
                            for (iter in lista) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        tint = Color.Black,
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp)
                                    )
                                    Text(
                                        text = "+1", fontFamily = Pixel,
                                        fontWeight = FontWeight.Bold,

                                        fontSize = 13.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "PUNTAJE: $puntaje",
                    fontFamily = Pixel,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black,
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Default.Save,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(
                                    Routes.formInsertpf.createRoute(puntaje.toString())
                                )
                            }
                            .size(40.dp)
                            .background(Color.Black)
                            .padding(5.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.RestartAlt,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                puntaje = 0
                                statusList = true
                                lista.clear()
                            }
                            .size(40.dp)
                            .background(Color.Black)
                            .padding(5.dp)
                    )
                }
            }

            item {
                if (resultado) {
                    marcadorPF(picas = picas.toString(), fijas = fijas.toString())
                } else {
                    marcadorPF(picas = picas.toString(), fijas = fijas.toString())
                }
            }





            fun Verificar() {



                if (numUser.toIntOrNull() != null && numUser.all { it.isDigit() }) {
                    println("Es un entero: $numero")
                }else {
                    error = true
                    return
                }



                if (numero.size == puntaje) {
                    numero = generarNumerosSinRepeticion(10)
                } else {
                    if (numUser.length <= 3 || numUser.length > 4) {
                        error = true
                        resultado = false
                    } else {
                        if (numUser.toInt() == numero[puntaje]) {
                            victoria = true
                        } else {
                            numero[puntaje].toString().forEach {
                                if (numUser.contains(it.toString()) && numero[puntaje].toString()
                                        .indexOf(it) == numUser.indexOf(it)
                                ) {
                                    count += 1
                                }
                                fijas = count

                                if (numUser.contains(it) && numero[puntaje].toString()
                                        .indexOf(it) != numUser.indexOf(it)
                                ) {
                                    count2 += 1
                                }
                                picas = count2
                            }
                            error = false
                            resultado = true
                            count = 0
                            count2 = 0
                        }// Fin del If2
                    } // Fin del If1
                }
            }// fin de Verficar

            item {
                btnEnviar(funcion = { Verificar() })
            }

            item {
                TextField(

                    value = numUser,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primaryVariant),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    onValueChange = { numUser = it },
                    textStyle = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontFamily = Pixel,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colors.onPrimary
                    )
                )
            }


            item {
                if (error) {
                    textAlert(texto = stringResource(R.string.alertPF))
                }
            }


        } // fin del lazycolumn
        if (victoria) {
            puntaje += 1
            statusList = true
            lista.add(puntaje)

            victoryPF {victoria = !victoria}

            statusList = false
        }


    }
} // fin de la fun PicasYFijas