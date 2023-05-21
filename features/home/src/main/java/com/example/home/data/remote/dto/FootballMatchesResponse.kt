package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class FootballMatchesResponse(
    @SerialName("competition")
    val competition: Competition,
    @SerialName("count")
    val count: Int,
    @SerialName("matches")
    val matches: List<Matche>
)

@Serializable
data class Competition(
    @SerialName("area")
    val area: Area,
    @SerialName("code")
    val code: String,
    @SerialName("id")
    val id: Int,
    @SerialName("lastUpdated")
    val lastUpdated: String,
    @SerialName("name")
    val name: String,
    @SerialName("plan")
    val plan: String
)


@Serializable
data class Matche(
    @SerialName("awayTeam")
    val awayTeam: AwayTeam,
    @SerialName("homeTeam")
    val homeTeam: HomeTeam,
    @SerialName("id")
    val id: Int,
    @SerialName("lastUpdated")
    val lastUpdated: String,
    @SerialName("matchday")
    val matchday: Int,
    @SerialName("odds")
    val odds: Odds,
    @SerialName("referees")
    val referees: List<Referee>,
    @SerialName("score")
    val score: Score,
    @SerialName("season")
    val season: Season,
    @SerialName("stage")
    val stage: String,
    @SerialName("status")
    val status: String,
    @SerialName("utcDate")
    val utcDate: String
)

@Serializable
data class Area(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)

@Serializable
data class AwayTeam(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)

@Serializable
data class HomeTeam(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)

@Serializable
data class Odds(
    @SerialName("msg")
    val msg: String
)

@Serializable
data class Referee(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("nationality")
    val nationality: String?,
    @SerialName("role")
    val role: String
)

@Serializable
data class Score(
    @SerialName("duration")
    val duration: String,
    @SerialName("fullTime")
    val fullTime: FullTime,
    @SerialName("halfTime")
    val halfTime: HalfTime?,
    @SerialName("winner")
    val winner: String?
)

@Serializable
data class Season(
    @SerialName("currentMatchday")
    val currentMatchday: Int,
    @SerialName("endDate")
    val endDate: String,
    @SerialName("id")
    val id: Int,
    @SerialName("startDate")
    val startDate: String
)


@Serializable
data class FullTime(
    @SerialName("awayTeam")
    val awayTeam: Int?,
    @SerialName("homeTeam")
    val homeTeam: Int?
)

@Serializable
data class HalfTime(
    @SerialName("awayTeam")
    val awayTeam: Int?,
    @SerialName("homeTeam")
    val homeTeam: Int?
)
