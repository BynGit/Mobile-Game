package com.example.games2.models

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.example.games2.R
import com.google.android.gms.auth.api.signin.GoogleSignInClient


class MainViewModel : ViewModel() {
    private val isLoading = MutableLiveData(false)
    private val statusNav = MutableLiveData(false)

    // private val nom = MutableLiveData("")

    val state: MutableState<LoginState> = mutableStateOf(LoginState())


    fun isLoading(): LiveData<Boolean> = isLoading
    fun statusNav(): LiveData<Boolean> = statusNav

    fun LoginWithGoogle(activity: Activity) {
        isLoading.postValue(true)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail().build()

        val client = GoogleSignIn.getClient(activity, gso)

// 39 97
        val singInIntent: Intent = client.getSignInIntent()
        activity.startActivityForResult(singInIntent, 1)




    }// fin del LoginWithGoogle


    fun finishLogin(accountTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = accountTask.getResult(ApiException::class.java)



            account?.idToken?.let { token ->
                val auth = FirebaseAuth.getInstance()

                val credential = GoogleAuthProvider.getCredential(token, null)

                auth.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var user = auth.currentUser

                        state.value = state.value.copy(
                            nombre = "${user?.displayName}",
                            urlPhoto = user?.photoUrl.toString()
                        )

                        statusNav.postValue(true)
                        Log.d("Ok", "Ingreso1 ${user?.displayName}")



                    } else {
                        Log.d("Error", "No se pudo conectar")
                    }

                    isLoading.postValue(false)
                }
            }
        } catch (e: ApiException) {
            Log.d(ContentValues.TAG, "signInResult:failed code=" + e.statusCode)
        }
        Log.d("Ok", "Ingreso 55555555555555555555555")
        isLoading.postValue(false)
    } // fin de la fun finishLogin

    fun singOut(activity: Activity) {
        val auth = FirebaseAuth.getInstance()
        val googleSignInClient: GoogleSignInClient
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(activity, gso)

        //SignInOut
        auth.signOut()
        googleSignInClient.signOut().addOnSuccessListener {
            statusNav.postValue(false)
        }

    }


}  // Fin del MainViewModel