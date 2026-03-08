package dev.mackenzie.agiplayer.core.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mackenzie.agiplayer.core.data.repository.LocalMediaRepository
import dev.mackenzie.agiplayer.core.data.repository.LocalPreferencesRepository
import dev.mackenzie.agiplayer.core.data.repository.LocalSearchHistoryRepository
import dev.mackenzie.agiplayer.core.data.repository.MediaRepository
import dev.mackenzie.agiplayer.core.data.repository.PreferencesRepository
import dev.mackenzie.agiplayer.core.data.repository.SearchHistoryRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMediaRepository(
        videoRepository: LocalMediaRepository,
    ): MediaRepository

    @Binds
    @Singleton
    fun bindsPreferencesRepository(
        preferencesRepository: LocalPreferencesRepository,
    ): PreferencesRepository

    @Binds
    @Singleton
    fun bindsSearchHistoryRepository(
        searchHistoryRepository: LocalSearchHistoryRepository,
    ): SearchHistoryRepository
}
