package com.example.home.data.remote.service.galleryPhotos

import com.example.home.data.remote.dto.FootballMatchesResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class FootballServiceImpl @Inject constructor(val httpClient: HttpClient): FootballService {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrlFromNative(): String


    override suspend fun callFootballMatches(): FootballMatchesResponse {
        return httpClient.get<FootballMatchesResponse> {
            url(getBaseUrlFromNative())
        }
    }


}