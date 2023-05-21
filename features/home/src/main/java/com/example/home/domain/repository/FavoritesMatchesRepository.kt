package com.example.home.domain.repository

import com.example.home.domain.entity.Match

interface FavoritesMatchesRepository {

    suspend fun getAllFavoritesMatches(): List<Match>?

}