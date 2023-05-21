package com.example.home.data.repository.favorites

import com.example.home.data.local.MatchesDao
import com.example.home.data.mapper.mapFavoritesToDomainMatch
import com.example.home.domain.entity.Match
import com.example.home.domain.repository.FavoritesMatchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoritesMatchesRepositoryImp @Inject constructor(private val matchesDao: MatchesDao)
    : FavoritesMatchesRepository {

    override suspend fun getAllFavoritesMatches(): List<Match>? {
        return withContext(Dispatchers.IO){
            val allMatches = matchesDao.getAllFavorites()
            allMatches.mapFavoritesToDomainMatch()
        }
    }




}