package com.example.home.data.mapper

import android.util.Log
import com.example.database.dbManager.FavoritesMatchesEntity
import com.example.home.data.remote.dto.FootballMatchesResponse
import com.example.home.domain.entity.Match
import com.example.utils.core.convertDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun FootballMatchesResponse?.mapToDomainMatch(favorites: List<FavoritesMatchesEntity>?): MutableList<Match>? =
    this?.matches?.toMutableList()?.map {
        Match(
            it.id,
            ("${it.homeTeam.name} - ${it.awayTeam.name}"),
            ("( ${it.score.fullTime.homeTeam} - ${it.score.fullTime.awayTeam} )"),
            it.utcDate,
            it.utcDate.convertDate(),
            favorites?.any { saved-> saved.id == it.id } ?: false,
            it.score.winner
        )
    }?.toMutableList()


fun List<FavoritesMatchesEntity>?.mapFavoritesToDomainMatch(): MutableList<Match>? =
    this?.toMutableList()?.map {
        Match(
            it.id,
            it.teams,
            it.result,
            it.date , // should be replaced
            it.date,
            true,
            it.winner
        )
    }?.toMutableList()



fun Match.mapToFavoriteMatch(): FavoritesMatchesEntity =
    FavoritesMatchesEntity(
        id,
        teams,
        result,
        date,
        winner
    )