package com.example.shift_android_1.ui.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftBackground
import com.example.shift_android_1.theme.shiftPrimary

@Composable
fun infoTopAppBarView(viewModel: MainViewModel, navController: NavController) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().background(color = shiftBackground)){
        IconButton(onClick = {
            viewModel.restorePopUps()
            navController.navigate("main_screen")
            {
                popUpTo(navController.graph.findStartDestination().id)
                {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }){
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(imageVector = Icons.Filled.ArrowLeft,
                    contentDescription = "Test", tint = shiftPrimary, modifier = Modifier.size(30.dp)
                )
                Text("Back", fontWeight = FontWeight.Bold, fontSize = 15.sp, color= shiftPrimary)
            }

        }
        Text("SHIFT_ANDROID_1", Modifier.padding(horizontal = 15.dp),
            fontWeight = FontWeight.Bold, fontSize = 20.sp, color = shiftPrimary)
    }
}