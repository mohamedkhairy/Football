package com.example.home.data.mapper

import com.example.home.data.local.entity.FavoritesMatchesEntity
import com.example.home.data.remote.dto.FootballMatchesResponse
import com.example.home.domain.entity.Match


fun FootballMatchesResponse?.mapToDomainMatch(): MutableList<Match>? =
    this?.matches?.toMutableList()?.map {
        Match(
            it.id,
            ("${it.homeTeam.name} - ${it.awayTeam.name}"),
            ("( ${it.score.fullTime.homeTeam} - ${it.score.fullTime.awayTeam} )"),
            it.utcDate
        )
    }?.toMutableList()


fun List<FavoritesMatchesEntity>?.mapFavoritesToDomainMatch(): List<Match>? =
    this?.toMutableList()?.map {
        Match(
            it.id,
            it.teams,
            it.result,
            it.date
        )
    }


fun Match.mapToFavoriteMatch(): FavoritesMatchesEntity=
    FavoritesMatchesEntity(
        id,
        teams,
        result,
        date
    )