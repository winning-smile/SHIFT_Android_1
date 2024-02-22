package com.example.shift_android_1.ui.body

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun configBody(innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 20.dp)) {

    Text("App_Name: SHIFT_ANDROID_1")
    Text("App_Version: 0.75 beta [stable]")
    Text("App_Info: This application is designed to access the Random User Generator API, as a result of which the generated user cards are displayed. By clicking on the card, you will be redirected to the screen with full information about the user. When you click on the corresponding icons, you switch to other applications (Mail, Calls, Maps). By clicking the refresh button on the main screen, new user cards are loaded. When downloading, the data is stored in the phone's memory. The application was developed as part of a test assignment for taking courses on Android development in the CFT SHIFT.")
    Text("App_Developer: Mack Alex")
        Image(
                rememberAsyncImagePainter("https://i.postimg.cc/L4qZCL5v/photo-2023-05-18-11-28-51.jpg"),
                contentDescription = "developer's photo"
            )
}
}