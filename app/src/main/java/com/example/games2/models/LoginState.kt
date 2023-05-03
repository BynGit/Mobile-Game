package com.example.games2.models

import androidx.annotation.StringRes

data class LoginState(
    val nombre:String = "",
    val urlPhoto:String = "",

    @StringRes val errorMessages: Int? = null

)