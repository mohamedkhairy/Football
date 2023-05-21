package com.example.home.data.repository.matches

import com.example.home.data.mapper.mapToDomainMatch
import com.example.home.data.remote.service.footballMatches.FootballService
import com.example.home.domain.entity.Match
import com.example.home.domain.repository.AllFootballMatchesRepository
import javax.inject.Inject

class AllFootballMatchesRepositoryImp @Inject constructor(private val service: FootballService) :
    AllFootballMatchesRepository {

    override suspend fun getAllFootballMatches(): MutableList<Match>? {
        val allMatches = service.callFootballMatches()
        return allMatches.mapToDomainMatch()
    }
}