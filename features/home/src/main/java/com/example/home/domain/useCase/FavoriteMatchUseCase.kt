package com.example.home.domain.useCase

import com.example.home.domain.entity.Match
import com.example.home.domain.repository.FavoritesMatchesRepository
import com.example.utils.usecases.FlowUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FavoriteMatchUseCase @Inject constructor(
    private val favoritesMatchesRepository: FavoritesMatchesRepository
) : FlowUseCase<Unit, List<Match>?>(Dispatchers.IO) {

    override fun execute(parameters: Unit): Flow<List<Match>?> =
        flow {
            val result = favoritesMatchesRepository.getAllFavoritesMatches()
//            result?.let {
            //do logic
//            }
            emit(result)

        }



}