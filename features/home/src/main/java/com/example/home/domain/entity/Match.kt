package com.example.home.domain.entity

data class Match (
    val id: Int,
    val teams: String,
    val result: String,
    val date: String,
    val time: String,
    var isFavorite: Boolean = false,
    val winner: String?
)