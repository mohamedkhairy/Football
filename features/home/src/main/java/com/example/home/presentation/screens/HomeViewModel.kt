package com.example.home.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.data.remote.service.footballMatches.FootballService
import com.example.home.domain.entity.Match
import com.example.home.domain.useCase.AllFootballMatchesUseCase
import com.example.home.domain.useCase.FavoriteMatchUseCase
import com.example.home.domain.useCase.ToggleFavoritesUseCase
import com.example.utils.core.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(val matchesUseCas: AllFootballMatchesUseCase,
                                        val favoriteMatchUseCase: FavoriteMatchUseCase,
                                        val toggleFavoritesUseCase: ToggleFavoritesUseCase) :
    ViewModel() {


    val matchList = mutableStateListOf<Match>()
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val isError: MutableState<Boolean> = mutableStateOf(false)

    init {
        getFootballMatches()
    }


     fun getFootballMatches() {
         viewModelScope.launch(Dispatchers.Main) {
             matchesUseCas(Unit)
                 .collect { result ->
                     when (result) {
                         is DataState.Loading -> {
                             loading.value = true
                         }
                         is DataState.Success -> {
                             loading.value = false
                             isError.value = false

                             result.data?.let {
                                 matchList.clear()
                                 matchList.addAll(it)
                             }

                         }
                         is DataState.Error -> {
                             loading.value = false
                            isError.value = true
                         }

                         else -> {
                             loading.value = false
                         }
                     }
                 }
         }
     }

    fun getFavoriteMatches() {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMatchUseCase(Unit)
                .collect { result ->
                    when (result) {
                        is DataState.Loading -> {
                            loading.value = true
                        }
                        is DataState.Success -> {
                            loading.value = false
                            isError.value = false

                            result.data?.let {
                                matchList.clear()
                                matchList.addAll(it)
                            }

                        }
                        is DataState.Error -> {
                            loading.value = false
                            isError.value = true
                        }

                        else -> {
                            loading.value = false
                        }
                    }
                }
        }
    }


    fun addToFavorite(index: Int, match: Match) {
        viewModelScope.launch(Dispatchers.IO) {
            toggleFavoritesUseCase.add(match).collectLatest {
                updateList(index,match)
            }
        }
    }

    fun removeFavorite(index: Int, match: Match) {
        viewModelScope.launch(Dispatchers.IO) {
            toggleFavoritesUseCase.remove(match).collectLatest {
                        updateList(index,match)
            }
        }
    }

    private fun updateList(index: Int, match: Match){
            matchList[index] = match
    }


}