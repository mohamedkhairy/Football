package com.example.home.data.repository.matches

import com.example.database.dbManager.MatchesDao
import com.example.home.data.mapper.mapToDomainMatch
import com.example.home.data.remote.service.footballMatches.FootballService
import com.example.home.domain.entity.Match
import com.example.home.domain.repository.AllFootballMatchesRepository
import javax.inject.Inject

class AllFootballMatchesRepositoryImp @Inject constructor(private val service: FootballService,
                                                          private val matchesDao: MatchesDao) :
    AllFootballMatchesRepository {

    override suspend fun getAllFootballMatches(): MutableList<Match>? {
        val allMatches = service.callFootballMatches()
        val favorites = matchesDao.getAllFavorites()
        return allMatches.mapToDomainMatch(favorites)
    }
}