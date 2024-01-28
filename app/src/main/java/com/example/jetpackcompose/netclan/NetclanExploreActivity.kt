package com.example.jetpackcompose.netclan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.jetpackcompose.netclan.component.ExploreIndividual

class NetclanExploreActivity : ComponentActivity() {

    private val viewModel: NetclanViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { ExploreIndividual(viewModel) }
    }
}