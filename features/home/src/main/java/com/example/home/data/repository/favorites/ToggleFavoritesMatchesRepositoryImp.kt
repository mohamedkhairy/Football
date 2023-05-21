package com.example.home.data.repository.favorites

import com.example.home.data.local.MatchesDao
import com.example.home.data.mapper.mapToFavoriteMatch
import com.example.home.domain.entity.Match
import com.example.home.domain.repository.ToggleFavoritesMatchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToggleFavoritesMatchesRepositoryImp @Inject constructor(private val matchesDao: MatchesDao) :
    ToggleFavoritesMatchesRepository {


    override suspend fun addToFavorites(match: Match) {
        return withContext(Dispatchers.IO){
            matchesDao.save(match.mapToFavoriteMatch())
        }
    }

    override suspend fun removeFromFavorites(id: Int): Int? {
        return withContext(Dispatchers.IO){
            matchesDao.deleteById(id)
        }
    }

    override suspend fun isFavorite(id: Int): Boolean {
        return withContext(Dispatchers.IO){
            matchesDao.isExist(id)
        }
    }

}