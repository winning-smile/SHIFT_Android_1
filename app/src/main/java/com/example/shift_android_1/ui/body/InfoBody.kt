package com.example.shift_android_1.ui.body

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.shift_android_1.models.ApiResponse
import com.example.shift_android_1.models.MainViewModel
import com.example.shift_android_1.theme.shiftPrimary


@Composable
fun infoBody(result: ApiResponse?, viewModel: MainViewModel, innerPadding: PaddingValues)
{
    if (result != null){
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical=innerPadding.calculateTopPadding()).fillMaxHeight().fillMaxWidth().verticalScroll(
            rememberScrollState()
        )){
            // IMAGE
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp), horizontalArrangement = Arrangement.Center){
                Image(
                    rememberAsyncImagePainter(result.results[0].picture.large), contentDescription = "Test",contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp).clip(RoundedCornerShape(16.dp)))
            }
            // BIO
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Text("BIO", fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color= shiftPrimary)
                IconButton(onClick = {viewModel.isSheetOpenBio = !viewModel.isSheetOpenBio}){
                    Icon(imageVector = if (!viewModel.isSheetOpenBio) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Test", tint = shiftPrimary
                    )
                }
            }
            AnimatedVisibility(
                visible=viewModel.isSheetOpenBio,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically()
            )
            {
                Column {
                    Text("Name: ${result.results[0].name.title} ${result.results[0].name.first} ${result.results[0].name.last}")
                    Text("Gender: ${result.results[0].gender}")
                    Text("Date of birth: ${result.results[0].dob.date} (${result.results[0].dob.age})")

                }
            }

            // CONTACTS [EMAIL, PHONE]
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                Text("Contacts", fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color= shiftPrimary)
                IconButton(onClick = {viewModel.isSheetOpenContact = !viewModel.isSheetOpenContact}){
                    Icon(imageVector = if (!viewModel.isSheetOpenContact) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Test", tint = shiftPrimary
                    )
                }
            }
            AnimatedVisibility(
                visible=viewModel.isSheetOpenContact,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically()
            )
            {
                Column {
                    Text("Email: ${result.results[0].email}")
                    Text("Phone number: ${result.results[0].phone}")
                    Text("Cell: ${result.results[0].cell}")
                }
            }
            // LOCATION
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("Location", fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color= shiftPrimary)
                IconButton(onClick = {viewModel.isSheetOpenLocation = !viewModel.isSheetOpenLocation}) {
                    Icon(imageVector = if (!viewModel.isSheetOpenLocation) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Test", tint = shiftPrimary
                    )
                }
            }
            AnimatedVisibility(
                visible = viewModel.isSheetOpenLocation,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically()
            )
            {
                Column {
                    Text("Location: ${result.results[0].location.country}, ${result.results[0].location.state}, ${result.results[0].location.city}")
                    Text("Address: ${result.results[0].location.street.number} ${result.results[0].location.street.name}")
                    Text("Postcode: ${result.results[0].location.postcode}")
                    Text("Timezone: ${result.results[0].location.timezone.description} ${result.results[0].location.timezone.offset}")
                    Text("Coordinates: ${result.results[0].location.coordinates.latitude} ${result.results[0].location.coordinates.longitude}")
                }
            }

            // AC INF
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("Account information", fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color= shiftPrimary)
                IconButton(onClick = {viewModel.isSheetOpenLogin = !viewModel.isSheetOpenLogin}) {
                    Icon(imageVector = if (!viewModel.isSheetOpenLogin) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Test", tint = shiftPrimary
                    )
                }
            }
            AnimatedVisibility(
                visible = viewModel.isSheetOpenLogin,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically()
            )
            {
                Column {
                    Text("UUID: ${result.results[0].login.uuid}")
                    Text("Username: ${result.results[0].login.username}")
                    Text("Password: ${result.results[0].login.password}")
                    Text("Registration date: ${result.results[0].registered.date}")
                }
            }

            //METADATA
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("Metadata", fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color= shiftPrimary)
                IconButton(onClick = {viewModel.isSheetOpenMeta = !viewModel.isSheetOpenMeta}) {
                    Icon(imageVector = if (!viewModel.isSheetOpenMeta) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Test", tint = shiftPrimary
                    )
                }
            }
            AnimatedVisibility(
                visible = viewModel.isSheetOpenMeta,
                enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
                exit = slideOutVertically() + shrinkVertically()
            )
            {
                Column{
                    Text("ID: ${result.results[0].id.name}")
                    Text("ID value: ${result.results[0].id.value}")
                    Text("salt: ${result.results[0].login.uuid}")
                    Text("md5: ${result.results[0].login.username}")
                    Text("sha1: ${result.results[0].login.password}")
                    Text("sha256: ${result.results[0].registered.date}")
                }
            }

        }
    }
    else{
        Text("Error while fetching data")
    }
}