package com.example.home.domain.repository

import com.example.home.domain.entity.Match

interface AllFootballMatchesRepository {

    suspend fun getAllFootballMatches():  MutableList<Match>?

}