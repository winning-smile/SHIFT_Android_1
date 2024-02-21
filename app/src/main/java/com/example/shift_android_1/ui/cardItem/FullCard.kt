package com.example.shift_android_1.ui.cardItem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.shift_android_1.R
import com.example.shift_android_1.models.ApiResponse

@Composable
fun fullCard(person: ApiResponse) {
    Card(shape = RoundedCornerShape(16.dp), border = BorderStroke(2.dp, Color.White),
        modifier = Modifier.fillMaxWidth().height(80.dp).padding(7.dp), elevation = 5.dp){

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(rememberAsyncImagePainter(person.results[0].picture.medium), contentDescription = "Test",contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(16.dp)))

            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)){
                Text(text=person.results[0].name.first + " " + person.results[0].name.last, fontWeight = FontWeight.Bold)
                Text(text="Phone: " + person.results[0].phone)
                Text(text="Address: " + person.results[0].location.street.number.toString() + " " + person.results[0].location.street.name)
            }
        }
    }
}