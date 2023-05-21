package com.example.home.presentation.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.data.remote.service.footballMatches.FootballService
import com.example.home.domain.entity.Match
import com.example.home.domain.useCase.AllFootballMatchesUseCase
import com.example.utils.core.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(val matchesUseCas: AllFootballMatchesUseCase) :
    ViewModel() {


    val matchList: MutableState<List<Match>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val isError: MutableState<Boolean> = mutableStateOf(false)

    init {
        getFootballMatches()
    }

//    /**
//     * this method can emit 3 state to UI
//     * Loading -> when the app trying to get data
//     * Success -> when data return successfully
//     * Error -> will return old data if it's available or Error if not
//     * */
//    fun getAllUsers() {
//        viewModelScope.launch(Dispatchers.Main) {
//            allUsersUseCase.invoke().collect {
//                when (it) {
//                    is Resource.Loading -> {
//                        loading.value = true
//                        isError.value = false
//                    }
//                    is Resource.Success -> {
//                        loading.value = false
//                        isError.value = false
//                        it.data?.let { list -> usersList.value = list }
//                    }
//                    is Resource.Error -> {
//                        loading.value = false
//
//                        if (!it.data.isNullOrEmpty()) {
//                            usersList.value = it.data
//                            isError.value = false
//                        } else
//                            isError.value = true
//
//
//                    }
//                }
//            }
//        }
//    }



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
                             result.data?.let {
                                 matchList.value = it
                             }

                         }
                         is DataState.Error -> {
                             loading.value = false

                         }

                         else -> {
                             loading.value = false
                         }
                     }
                 }
         }
     }

}