package com.example.home.di

import com.example.home.data.local.MatchesDao
import com.example.home.data.repository.favorites.ToggleFavoritesMatchesRepositoryImp
import com.example.home.domain.repository.ToggleFavoritesMatchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object ToggleFavoritesRepositoryModule {


    @Provides
    fun provideToggleFavoritesMatchesRepository(matchesDao: MatchesDao): ToggleFavoritesMatchesRepository {
        return ToggleFavoritesMatchesRepositoryImp(matchesDao)
    }



}