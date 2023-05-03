package com.example.games2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.games2.models.MainViewModel
import com.example.games2.navegation.Navegacion
// import com.example.games2.ui.theme.Games2Theme
import com.example.games2.ui.theme.GamesTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel by viewModels()
            val isLoading by viewModel.isLoading().observeAsState(false)
            val statusNav by viewModel.statusNav().observeAsState(false)

            GamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navegacion(
                        isLoading = isLoading,
                        statusNav = statusNav,
                        onLoginClick = { viewModel.LoginWithGoogle(this@MainActivity) },
                        MainviewModel = viewModel,
                        singout = {viewModel.singOut(this@MainActivity)}
                    )

                }
            }
        }
    } // Fin del onCreate

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val viewModel: MainViewModel by viewModels()

        if (requestCode == 1) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            viewModel.finishLogin(task)
        }
    }
}