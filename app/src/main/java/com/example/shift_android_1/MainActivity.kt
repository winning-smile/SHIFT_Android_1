package com.example.shift_android_1

import PrefDataStore
import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowInsetsControllerCompat
import com.example.shift_android_1.models.ComposeNavigation
import com.example.shift_android_1.models.MainViewModel
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
        val context = this
        CoroutineScope(Dispatchers.IO).launch {
            prefDataStore.getInfo().collect() {
                withContext(Dispatchers.Main) {
                    if (it.apst == "") {
                        runBlocking {
                            launch {
                                viewModel.fetchFromApi(prefDataStore, context)
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

                ComposeNavigation(viewModel, prefDataStore)
            }
        }

    }