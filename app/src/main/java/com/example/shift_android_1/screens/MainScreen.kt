package com.example.shift_android_1.screens

import PrefDataStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.shift_android_1.models.DataState
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.models.ApiResponse
import com.example.shift_android_1.theme.shiftBackground
import com.example.shift_android_1.theme.shiftPrimary
import com.example.shift_android_1.ui.body.bottomBar
import com.example.shift_android_1.ui.body.topAppBarView
import com.example.shift_android_1.ui.cardItem.fullCard

/* TODO  УДАЛИТЬ НЕНУЖНЫЕ ИМПОРТЫ */
@Composable
fun mainScreen(viewModel: MainViewModel,  navController: NavController, prefDataStore: PrefDataStore)
{

    when (val result = viewModel.response.value) {
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().background(shiftBackground),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = shiftPrimary)
            }
        }

        is DataState.Success -> {
            Scaffold(
                topBar = { topAppBarView() },
                bottomBar = { bottomBar(viewModel, prefDataStore, navController) },
                backgroundColor = shiftBackground
            ) { innerPadding ->
                ShowLazyList(result.data, innerPadding,  navController)
            }
        }

        is DataState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = result.message
                )
            }
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error Fetching data",
                )
            }
        }
    }
}


@Composable
fun ShowLazyList(persons: MutableList<ApiResponse>, innerPadding: PaddingValues,  navController: NavController){
    LazyColumn(modifier = Modifier.padding(innerPadding)){
        items(persons) { person ->
            fullCard(person, navController)
        }
    }
}