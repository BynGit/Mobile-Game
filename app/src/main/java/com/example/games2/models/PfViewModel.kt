package com.example.games2.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class PfViewModel: ViewModel() {
    private val _pf = mutableStateOf<List<Pf>>(emptyList())

    val pf : State<List<Pf>>
        get() = _pf
    private val query = Firebase.firestore.collection("games1")


    init {
        query.addSnapshotListener {
                value, _->
            if(value != null) {
                _pf.value = value.toObjects()
            } // fin del if
        } // fin del addSnapshotListener
    } // fin del contructor init

} // fin de la clase