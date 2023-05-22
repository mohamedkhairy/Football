package com.example.home.domain.useCase

import com.example.home.domain.entity.Match
import com.example.home.domain.repository.ToggleFavoritesMatchesRepository
import com.example.utils.core.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class ToggleFavoritesUseCase @Inject constructor(
    private val toggleFavoritesMatchesRepository: ToggleFavoritesMatchesRepository
) {




    suspend fun remove(match: Match): Flow<DataState<Int?>> =
        flow {
            try {
                val result = toggleFavoritesMatchesRepository.removeFromFavorites(match.id)
                emit(DataState.success(result))

            } catch (e: Exception) {
                emit(DataState.Error(e.message))
            }
        }
            .flowOn(Dispatchers.IO)


    suspend fun add(match: Match): Flow<DataState<Unit>> =
        flow {
            try {

                val result = toggleFavoritesMatchesRepository.addToFavorites(match)
                emit(DataState.Success(result))


            } catch (e: Exception) {
                emit(DataState.Error(e.message))
            }
        }
            .flowOn(Dispatchers.IO)


    suspend fun isFavorite(id: Int): Flow<DataState<Boolean>> =
        flow {
            try {
                val result = toggleFavoritesMatchesRepository.isFavorite(id)
                emit(DataState.Success(result))

            } catch (e: Exception) {
                emit(DataState.Error(e.message))
            }
        }
            .flowOn(Dispatchers.IO)
}