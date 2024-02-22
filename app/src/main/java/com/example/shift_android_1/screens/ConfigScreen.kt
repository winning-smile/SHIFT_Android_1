package com.example.shift_android_1.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftBackground
import com.example.shift_android_1.ui.body.configBody
import com.example.shift_android_1.ui.body.infoTopAppBarView

@Composable
fun configScreen(viewModel: MainViewModel, navController: NavController){
    Scaffold(
        topBar = { infoTopAppBarView(viewModel, navController) },
        bottomBar = {},
        backgroundColor = shiftBackground
    ) { innerPadding ->
            configBody(innerPadding)
    }

}