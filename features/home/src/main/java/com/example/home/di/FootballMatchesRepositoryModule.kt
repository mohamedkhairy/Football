package com.example.home.di


import com.example.database.dbManager.MatchesDao
import com.example.home.data.remote.service.footballMatches.FootballService
import com.example.home.data.repository.matches.AllFootballMatchesRepositoryImp
import com.example.home.domain.repository.AllFootballMatchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object FootballMatchesRepositoryModule {

    @Provides
    fun provideFootballMatchesRepository( clientService: FootballService , matchesDao: MatchesDao) : AllFootballMatchesRepository {
        return AllFootballMatchesRepositoryImp(clientService, matchesDao)
    }



}