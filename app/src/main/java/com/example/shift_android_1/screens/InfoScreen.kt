package com.example.shift_android_1.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.shift_android_1.models.ApiResponse
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftBackground
import com.example.shift_android_1.ui.body.infoBody
import com.example.shift_android_1.ui.body.infoTopAppBarView

@Composable
fun infoScreen(result: ApiResponse?, viewModel: MainViewModel, navController: NavController){
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { infoTopAppBarView(viewModel, navController) },
        bottomBar = {},
        backgroundColor = shiftBackground,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
            infoBody(result, viewModel, innerPadding, snackbarHostState)
    }

}