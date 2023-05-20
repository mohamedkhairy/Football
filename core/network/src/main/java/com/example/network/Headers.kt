package com.example.network

object Headers {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getApiKeyName(): String
    external fun getApiKeyValue(): String

}