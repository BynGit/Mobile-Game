package com.example.games2.navegation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.games2.models.MainViewModel
import com.example.games2.models.PfViewModel
import com.example.games2.models.PopCatViewModel
import com.example.games2.screens.*

@Composable
fun Navegacion(
    isLoading: Boolean,
    statusNav: Boolean,
    singout: () -> Unit,
    onLoginClick: () -> Unit,
    MainviewModel: MainViewModel
) {
    val contr = rememberNavController()
    NavHost(navController = contr, startDestination = Routes.Login.route) {

        composable(Routes.Home.route) {
            Home(
                contr,
                singout,
                MainviewModel.state.value.nombre,
                MainviewModel.state.value.urlPhoto
            )
        }

        composable(Routes.Login.route) {
            if (statusNav) {
                LaunchedEffect(key1 = Unit) {
                    contr.navigate(
                        Routes.Home.route
                    ) {

                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }

                    }
                }
            } else {
                Login(
                    isLoading,
                    statusNav,
                    onLoginClick,
                    MainviewModel,
                    contr
                )
            }

        }



        composable(Routes.pf.route) { PicasYFijas(contr) }

        composable(Routes.popcat.route) { PopCat(contr) }

        composable(Routes.formInsertpf.route, arguments = listOf(navArgument("record") { type = NavType.StringType })) {
            formPF(contr, record = it.arguments?.getString("record") ?: "")
        }

        composable(Routes.formInsertpopcat.route, arguments = listOf(navArgument("record") { type = NavType.StringType })) {
            formPopCat(contr, record = it.arguments?.getString("record") ?: "")
        }

        composable(Routes.podioPF.route) { PodioPF(contr, PfViewModel()) }

        composable(Routes.podioPopCat.route) { PodioPopCat(contr, PopCatViewModel()) }
    }
}