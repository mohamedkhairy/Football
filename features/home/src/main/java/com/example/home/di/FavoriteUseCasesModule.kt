package com.example.home.di


import com.example.home.domain.repository.FavoritesMatchesRepository
import com.example.home.domain.repository.ToggleFavoritesMatchesRepository
import com.example.home.domain.useCase.FavoriteMatchUseCase
import com.example.home.domain.useCase.ToggleFavoritesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object FavoriteUseCasesModule {


    @Provides
    fun provideFavoritesUseCase(favoritesMatchesRepository: FavoritesMatchesRepository): FavoriteMatchUseCase {
        return FavoriteMatchUseCase(favoritesMatchesRepository)
    }

    @Provides
    fun provideToggleFavoritesUseCase(toggleFavoritesMatchesRepository: ToggleFavoritesMatchesRepository): ToggleFavoritesUseCase {
        return ToggleFavoritesUseCase(toggleFavoritesMatchesRepository)
    }


}