package com.example.shift_android_1.ui.cardItem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shift_android_1.R

@Preview(showSystemUi = true)
@Composable
fun fullCard(){
    Card(shape = RoundedCornerShape(16.dp), border = BorderStroke(2.dp, Color.White),
        modifier = Modifier.fillMaxWidth().height(80.dp).padding(7.dp), elevation = 5.dp){

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(R.drawable._6), contentDescription = "Test",contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(16.dp)))

            Column(modifier = Modifier.fillMaxWidth()){
                Text(text="Morris Steward")
                Text("(815) 474-8574")
                Text("8228 Stevens Creek Blvd")
            }
        }
    }
}