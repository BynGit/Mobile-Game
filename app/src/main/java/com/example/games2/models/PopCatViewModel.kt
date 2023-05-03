package com.example.games2.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class PopCatViewModel: ViewModel() {
    private val _popcat = mutableStateOf<List<PopCat>>(emptyList())

    val popcat : State<List<PopCat>>
        get() = _popcat
    private val query = Firebase.firestore.collection("games2")


    init {
        query.addSnapshotListener {
                value, _->
            if(value != null) {
                _popcat.value = value.toObjects()
            } // fin del if
        } // fin del addSnapshotListener
    }
}