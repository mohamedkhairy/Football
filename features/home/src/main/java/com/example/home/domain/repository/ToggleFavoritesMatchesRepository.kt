package com.example.home.domain.repository

import com.example.home.domain.entity.Match

interface ToggleFavoritesMatchesRepository {

    suspend fun addToFavorites(match: Match)

    suspend fun removeFromFavorites(id: Int): Int?

    suspend fun isFavorite(id: Int): Boolean
}