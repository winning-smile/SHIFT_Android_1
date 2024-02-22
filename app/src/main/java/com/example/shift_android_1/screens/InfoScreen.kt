package com.example.shift_android_1.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shift_android_1.R
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftPrimary

@Composable
fun infoScreen(viewModel: MainViewModel,  navController: NavController){
    Column(modifier= Modifier.fillMaxWidth()){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Image(
                painterResource(R.drawable._6), contentDescription = "Test",contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(16.dp)))
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){Text("Name")}

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){Text("Gender")}

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Text("Contacts")
                IconButton(onClick = {viewModel.test(viewModel.isSheetOpenContact)}){
                    Icon(imageVector = if (!viewModel.isSheetOpenContact.value) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Test", tint = shiftPrimary)
                }
        }
        Row{
            AnimatedVisibility(
                visible=viewModel.isSheetOpenContact.value,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically())
            {
                Row {
                    Text("poop")
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text("Location")
            IconButton(onClick = {viewModel.isSheetOpenLocation = !viewModel.isSheetOpenLocation}) {
                Icon(imageVector = if (!viewModel.isSheetOpenLocation) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                    contentDescription = "Test", tint = shiftPrimary)
            }
            AnimatedVisibility(
                visible = viewModel.isSheetOpenLocation,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically())
            {

            }
        }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text("Login information")
            IconButton(onClick = {viewModel.isSheetOpenLogin = !viewModel.isSheetOpenLogin}) {
                Icon(imageVector = if (!viewModel.isSheetOpenLogin) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                    contentDescription = "Test", tint = shiftPrimary)
            }
            AnimatedVisibility(
                visible = viewModel.isSheetOpenLogin,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically())
            {

            }
        }

    }
}