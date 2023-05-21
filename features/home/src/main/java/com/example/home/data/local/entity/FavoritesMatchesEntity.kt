package com.example.home.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_matches")
data class FavoritesMatchesEntity (
    @PrimaryKey
    val id: Int,
    val teams: String,
    val result: String,
    val date: String
)