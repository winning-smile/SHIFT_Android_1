package com.example.shift_android_1.ui.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shift_android_1.theme.shiftBackground
import com.example.shift_android_1.theme.shiftPrimary

@Composable
fun topAppBarView() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().background(color = shiftBackground)){
        Text("SHIFT_ANDROID_1", Modifier.padding(horizontal = 15.dp),
            fontWeight = FontWeight.Bold, fontSize = 20.sp, color = shiftPrimary)
    }
}