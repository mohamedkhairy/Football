package com.example.home.presentation.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(){

    val screenViewModel: HomeViewModel = hiltViewModel()


    Text(
        text = "${screenViewModel.matchList}",
        modifier = Modifier.fillMaxWidth()
    )


}