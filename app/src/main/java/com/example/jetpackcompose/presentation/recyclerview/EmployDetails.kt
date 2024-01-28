package com.example.jetpackcompose.presentation.recyclerview

data class EmployDetails(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val ImageId: Int = 0
)
