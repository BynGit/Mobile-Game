package com.example.games2.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.games2.components.uiForms


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun formPopCat(navController: NavController, record: String) {
    uiForms(navController = navController, record = record, nomBd = "games2", Pf = false)
}