package com.example.shift_android_1.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.shift_android_1.models.ApiResponse
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftBackground
import com.example.shift_android_1.ui.body.infoBody
import com.example.shift_android_1.ui.body.infoTopAppBarView

@Composable
fun infoScreen(result: ApiResponse?, viewModel: MainViewModel, navController: NavController){
    Scaffold(
        topBar = { infoTopAppBarView(viewModel, navController) },
        bottomBar = {},
        backgroundColor = shiftBackground
    ) { innerPadding ->
            infoBody(result, viewModel, innerPadding)
    }

}