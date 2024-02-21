package com.example.shift_android_1.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_android_1.pref.DataStorePreferenceRepository
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection


sealed class DataState {
    class Success(val data: MutableList<ApiResponse>) : DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}
class MainViewModel() : ViewModel() {
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchFromApi()
    }

    private fun <R> CoroutineScope.executeAsyncTask(onPreExecute: () -> Unit, doInBackground: () -> R, onPostExecute: (R) -> Unit) =
        launch {
            onPreExecute()
            val result = withContext(Dispatchers.IO) {
                doInBackground()
            }
            onPostExecute(result)
        }

    @SuppressLint("SuspiciousIndentation")
    private fun fetchFromApi() {
        response.value = DataState.Loading

            viewModelScope.executeAsyncTask(onPreExecute = {}, doInBackground = {
                val response = StringBuilder()

                val url = URL("https://randomuser.me/api/")
                for (i in 1..10) {
                    val connection = url.openConnection() as HttpsURLConnection
                    BufferedReader(InputStreamReader(connection.inputStream)).useLines { lines ->
                        for (line in lines) {
                            response.append(line).append("\n")
                        }
                    }
                }
                response
            },
                onPostExecute = {

                    val gson = GsonBuilder().create()
                    val tempList = mutableListOf<ApiResponse>()
                    val regex = Regex("\\{.results..*?\\}\n")
                    regex.findAll(it).forEach{ result->
                        Log.i("MDATA", result.value.toString())
                        tempList.add(gson.fromJson(result.value, ApiResponse::class.java))
                    }
                    response.value = DataState.Success(tempList)
                })
    }

}

