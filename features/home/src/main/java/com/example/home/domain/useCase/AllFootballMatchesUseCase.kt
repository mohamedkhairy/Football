package com.example.home.domain.useCase

import com.example.home.domain.entity.Match
import com.example.utils.core.DataState
import com.example.home.domain.repository.AllFootballMatchesRepository
import com.example.utils.usecases.FlowUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class AllFootballMatchesUseCase @Inject constructor(
    private val allFootballMatchesRepository: AllFootballMatchesRepository
) : FlowUseCase<Unit, List<Match>?>(Dispatchers.IO) {

    override fun execute(parameters: Unit): Flow<List<Match>?> =
        flow {
            val result = allFootballMatchesRepository.getAllFootballMatches()
//            result?.let {
                //do logic
//            }
            emit(result)

        }


}
