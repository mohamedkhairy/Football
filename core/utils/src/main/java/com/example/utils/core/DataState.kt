package com.example.utils.core

import com.example.core.domain.core.ProgressBarState


sealed class DataState<T> {


    data class Error<T>(
        val errorMessages: String? = null
    ): DataState<T>()

    data class Success<T>(
        val data: T? = null
    ): DataState<T>()

    data class Loading<T>(
        val progressBarState: ProgressBarState = ProgressBarState.Idle
    ): DataState<T>()



    companion object {


        fun <T> success(data: T): DataState<T> = Success(data)
    }
}

