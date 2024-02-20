package com.example.shift_android_1.models

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.Dictionary
import javax.net.ssl.HttpsURLConnection


//data class Person(val id: Long = counter++, val img: String?=null, val fname: String?=null, val birthday: String?=null,
//                   val eaddress: String?=null, val number: String?=null, val country: String?=null, val city: String?=null,
//                   val street: String?=null , val username: String?=null, val password: String?=null) {
//    companion object {
//        private var counter = 0L
//    }
//}

data class Person(val name: String, val gender: String)



sealed class DataState {
    class Success(val data: MutableList<Person>) : DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}

class MainViewModel : ViewModel() {

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
                val connection = url.openConnection() as HttpsURLConnection
                BufferedReader(InputStreamReader(connection.inputStream)).useLines { lines ->
                    for (line in lines) {
                        response.append(line).append("\n")
                    }
                }

                response.toString()
            },
                onPostExecute = {

                    val gson = GsonBuilder().create()
                    val root = gson.fromJson<ApiResponse>(it, ApiResponse::class.java)
                    val tempList = mutableListOf<Person>()
                    tempList.add(Person(gender = root.results[0].gender.toString(), name = root.results[0].name.first))
                    Log.i("DATA", root.results[0].gender.toString())
                    response.value = DataState.Success(tempList)
                })
    }
}

