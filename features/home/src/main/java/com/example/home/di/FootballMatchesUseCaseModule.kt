package com.example.home.di

import com.example.home.domain.repository.AllFootballMatchesRepository
import com.example.home.domain.useCase.AllFootballMatchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object FootballMatchesUseCaseModule {

    @Provides
    fun provideFootballMatchesUseCase(allFootballMatchesRepository: AllFootballMatchesRepository): AllFootballMatchesUseCase {
        return AllFootballMatchesUseCase(allFootballMatchesRepository)
    }

}