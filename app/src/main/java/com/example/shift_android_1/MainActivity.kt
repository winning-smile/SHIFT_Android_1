package com.example.shift_android_1

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowInsetsControllerCompat
import com.example.shift_android_1.models.ApiResponse
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.screens.mainScreen
import com.example.shift_android_1.theme.SHIFTTheme
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.parseColor("#ffeaec")
            window.navigationBarColor = Color.parseColor("#FFA42527")
            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.isAppearanceLightStatusBars = true

            mainScreen(viewModel)

        }
    }

}