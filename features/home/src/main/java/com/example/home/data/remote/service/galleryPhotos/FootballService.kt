package com.example.home.data.remote.service.galleryPhotos

import com.example.home.data.remote.dto.FootballMatchesResponse

//import com.example.data.dataSource.remote.dto.FlickrPhotosDto


interface FootballService {

    suspend fun callFootballMatches(): FootballMatchesResponse


}
