package com.example.jetpackcompose.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.presentation.recyclerview.Details
import com.example.jetpackcompose.presentation.recyclerview.EmployDetails

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun EmployeeCard(emp: EmployDetails) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
//            Toast.makeText(
//                context,
//                "Item click : ", Toast.LENGTH_SHORT
//            ).show()
        }
    ) {

        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                Arrangement.Center
            ) {
                Text(
                    text = emp.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Age :- " + emp.age.toString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = "Sex :- " + emp.sex,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

                Text(
                    text = "Description :- " + emp.description,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )
            }
            Image(
                painter = painterResource(emp.ImageId), contentDescription = "Profile Image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(8.dp)
                    .size(110.dp)
                    .clip((CircleShape))
            )
        }
    }
}

@Preview
@Composable
fun DetailsContent() {
    val context = LocalContext.current
    val employees = remember { Details.EmployDetailsList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp)
    ) {
        items(
            employees.size
        ) {
            EmployeeCard(employees[it])
        }
        itemsIndexed(employees) { index, item ->
//            Toast.makeText(
//                context,
//                "" + index, Toast.LENGTH_SHORT
//            ).show()
        }
    }
}