package com.example.jetpackcompose.netclan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R

@Composable
fun NetclanAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFF0E2E43)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_drawer),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
                text = "Howdy Vishwas !!", color = Color.White, fontSize = 14.sp
            )
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(top = 4.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location_pin),
                    contentDescription = null,
                    tint = Color.White, modifier = Modifier.padding(top = 2.dp)
                )
                Text(
                    text = "Kayasthwara Mohalla, Rewari", color = Color.White, fontSize = 12.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}