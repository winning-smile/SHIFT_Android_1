package com.example.shift_android_1.models

import PrefDataStore
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shift_android_1.screens.configScreen
import com.example.shift_android_1.screens.infoScreen
import com.example.shift_android_1.screens.mainScreen

@Composable
fun ComposeNavigation(viewModel: MainViewModel, prefDataStore: PrefDataStore) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable("main_screen") {
            mainScreen(viewModel, navController = navController, prefDataStore)
        }
        composable(route = "info_screen")
        {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<ApiResponse>("person_data")
            infoScreen(result, viewModel, navController = navController)
        }
        composable(route = "config_screen")
        {
           configScreen(viewModel, navController = navController)
        }
    }
}