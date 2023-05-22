package com.example.home.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.domain.entity.Match
import com.example.home.presentation.components.AppToolBar
import com.example.home.presentation.components.MatchCardItem
import com.example.utils.core.MenuAction
import com.example.utils.ui.Loading

@Composable
fun HomeScreen(){

    val screenViewModel: HomeViewModel = hiltViewModel()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        val isLoading by remember {screenViewModel.loading}
        val matchesList = remember {screenViewModel.matchList}


        AppToolBar(
            {
                   when(it){
                       is MenuAction.All ->{
                           screenViewModel.getFootballMatches()
                       }
                       is MenuAction.Favorites ->{
                           screenViewModel.getFavoriteMatches()
                       }
                   }
        }
            ,{


            LazyColumn{
                itemsIndexed(items = matchesList) { index, item ->
                    MatchCardItem(match = item){
                        if (it.isFavorite){
                            screenViewModel.removeFavorite(index , it.copy(isFavorite = false))
                        }else {
                            screenViewModel.addToFavorite(index, it.copy(isFavorite = true))
                        }

                    }
                }
            }

                Loading(isLoading = isLoading)

            })
    }


}