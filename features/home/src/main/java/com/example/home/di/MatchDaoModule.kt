package com.example.home.di


import com.example.database.dbManager.DatabaseManager
import com.example.database.dbManager.MatchesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatchDaoModule {

    @Provides
    @Singleton
    fun provideMatchesDao(database: DatabaseManager) : MatchesDao =
        database.favoritesMatchesDao()

}