package com.example.home.di

import com.example.home.data.local.MatchesDao
import com.example.home.data.repository.favorites.FavoritesMatchesRepositoryImp
import com.example.home.domain.repository.FavoritesMatchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object FavoritesRepositoryModule {

    @Provides
    fun provideFavoritesRepository(matchesDao: MatchesDao) : FavoritesMatchesRepository {
        return FavoritesMatchesRepositoryImp(matchesDao)
    }

}
