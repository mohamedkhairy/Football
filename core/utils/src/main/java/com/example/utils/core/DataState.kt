package com.example.utils.core


sealed class DataState<T> {


    data class Error<T>(
        val errorMessages: String? = null
    ): DataState<T>()

    data class Success<T>(
        val data: T? = null
    ): DataState<T>()

    class Loading<T>() : DataState<T>()



    companion object {


        fun <T> success(data: T): DataState<T> = Success(data)
    }
}

