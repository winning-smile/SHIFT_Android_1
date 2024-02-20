package com.example.shift_android_1.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.example.shift_android_1.models.MainModel
import com.example.shift_android_1.models.Person
import com.example.shift_android_1.ui.cardItem.fullCard

@Composable
fun mainScreen(){

    @Composable
    fun ShowLazyList(persons: MutableList<Person>, innerPadding: PaddingValues, viewModel: MainModel) {
        LazyColumn(modifier = Modifier.padding(innerPadding).zIndex(-1f)){
            items(persons) { person ->
                //fullCard(person)
            }
        }
    }
}