package com.example.shift_android_1.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class Person(val id: Long = counter++, val img: String?=null, val fname: String?=null, val eaddress: String?=null,
                   val birthday: String?=null, val address: String?=null, val number: String?=null,
                   val password: String?=null) {
    companion object {
        private var counter = 0L
    }
}


sealed class DataState {
    class Success(val data: MutableList<Person>) : DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}

class MainModel : ViewModel() {

    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchFromApi()
    }

    private fun fetchFromApi() {
        val tempList = mutableListOf<Person>()
        response.value = DataState.Loading

    }
}