package com.example.home.data.remote.service.footballMatches

import com.example.home.data.remote.dto.FootballMatchesResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class FootballServiceImpl @Inject constructor(val httpClient: HttpClient): FootballService {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrlFromNative(): String
    external fun getApiKeyName(): String
    external fun getApiKeyValue(): String


    private val endpointUrl = getBaseUrlFromNative()+"competitions/2021/matches/"
    override suspend fun callFootballMatches(): FootballMatchesResponse {
        return httpClient.get<FootballMatchesResponse> {
            url(endpointUrl)
            headers {
                append(getApiKeyName(), getApiKeyValue())
            }
        }
    }


}