package com.example.shift_android_1

import PrefDataStore
import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.core.view.WindowInsetsControllerCompat
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.screens.mainScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val viewModel = MainViewModel()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var prefDataStore = PrefDataStore(this)
        CoroutineScope(Dispatchers.IO).launch {
            prefDataStore.getInfo().collect() {
                withContext(Dispatchers.Main) {
                    Log.i("hope", it.apst)
                    if (it.apst == "") {
                        runBlocking {
                            val job = launch {
                                Log.i("hope", "fetch")
                                viewModel.fetchFromApi(prefDataStore)
                            }
                        }
                    } else {
                            prefDataStore.getInfo().collect() {
                                    viewModel.setFromStorage(it.apst)
                            }
                        }
                    }
                }
            }

            setContent {
                window.statusBarColor = Color.parseColor("#ffeaec")
                window.navigationBarColor = Color.parseColor("#FFA42527")
                val controller = WindowInsetsControllerCompat(window, window.decorView)
                controller.isAppearanceLightStatusBars = true

                mainScreen(viewModel)
            }
        }

    }