package com.example.jetpackcompose.presentation.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.presentation.compose.DetailsContent
import com.example.jetpackcompose.ui.theme.JetPackComposeDemoTheme

class RecyclerViewActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.onSurface,
                ) {
                    DetailsContent()
                }
            }
        }
    }
}