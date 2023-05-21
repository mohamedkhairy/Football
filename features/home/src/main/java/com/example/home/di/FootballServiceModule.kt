package com.example.home.di


import com.example.home.data.remote.service.footballMatches.FootballService
import com.example.home.data.remote.service.footballMatches.FootballServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.*

@Module
@InstallIn(ViewModelComponent::class)
object FootballServiceModule {

    @Provides
    fun provideFootballService(httpClient: HttpClient): FootballService {
        return FootballServiceImpl(httpClient)
    }

}