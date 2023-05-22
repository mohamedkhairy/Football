package com.example.home.domain.useCase

import android.util.Log
import com.example.home.domain.core.sortByDate
import com.example.home.domain.entity.Match
import com.example.home.domain.repository.AllFootballMatchesRepository
import com.example.utils.core.convertDate
import com.example.utils.usecases.FlowUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

class AllFootballMatchesUseCase @Inject constructor(
    private val allFootballMatchesRepository: AllFootballMatchesRepository
) : FlowUseCase<Unit, MutableList<Match>?>(Dispatchers.IO) {

    override fun execute(parameters: Unit): Flow<MutableList<Match>?> =
        flow {
            val result = allFootballMatchesRepository.getAllFootballMatches()
            val sorted= result?.sortByDate()
            emit(sorted)

        }


}
