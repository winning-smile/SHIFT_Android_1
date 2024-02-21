package com.example.shift_android_1.ui.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shift_android_1.theme.shiftOnPrimary
import com.example.shift_android_1.theme.shiftPrimary

@Composable
fun bottomBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 0.dp).background(shiftPrimary).fillMaxWidth().
        padding(vertical = 5.dp).height(40.dp)
    )
    {
        Text("Info", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = shiftOnPrimary, modifier = Modifier.weight(1f))
        Divider(
            color = shiftOnPrimary,
            modifier = Modifier.fillMaxHeight().width(1.dp)
        )
        Text("Refresh", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = shiftOnPrimary, modifier = Modifier.weight(1f)
        )

    }
}