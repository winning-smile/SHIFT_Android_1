package com.example.shift_android_1.ui.body

import PrefDataStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftOnPrimary
import com.example.shift_android_1.theme.shiftPrimary

@Composable
fun bottomBar(viewModel: MainViewModel, prefDataStore: PrefDataStore, navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 0.dp).clip(shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)).background(shiftPrimary).fillMaxWidth().
        padding(vertical = 5.dp).height(35.dp)
    )
    {
        IconButton(onClick = {navController.navigate("config_screen")
        {
            popUpTo(navController.graph.findStartDestination().id)
            {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
                             }, modifier = Modifier.weight(1f)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Text("Info ", fontWeight = FontWeight.Bold, fontSize = 15.sp, color= Color.White)
                Icon(imageVector = Icons.Filled.Info,
                    contentDescription = "Test", tint = Color.White, modifier = Modifier.size(30.dp)
                )
            }
        }

        Divider(color = shiftOnPrimary, modifier = Modifier.fillMaxHeight().width(1.dp))

        IconButton(onClick = {viewModel.fetchFromApi(prefDataStore)}, modifier = Modifier.weight(1f)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Text("Refresh", fontWeight = FontWeight.Bold, fontSize = 15.sp, color= Color.White)
                Icon(imageVector = Icons.Filled.Refresh,
                    contentDescription = "Test", tint = Color.White, modifier = Modifier.size(30.dp)
                )
            }
        }

    }
}