package dev.mackenzie.agiplayer.core.media

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mackenzie.agiplayer.core.media.services.LocalMediaService
import dev.mackenzie.agiplayer.core.media.services.MediaService
import dev.mackenzie.agiplayer.core.media.sync.LocalMediaInfoSynchronizer
import dev.mackenzie.agiplayer.core.media.sync.LocalMediaSynchronizer
import dev.mackenzie.agiplayer.core.media.sync.MediaInfoSynchronizer
import dev.mackenzie.agiplayer.core.media.sync.MediaSynchronizer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MediaModule {

    @Binds
    @Singleton
    fun bindsMediaSynchronizer(
        mediaSynchronizer: LocalMediaSynchronizer,
    ): MediaSynchronizer

    @Binds
    @Singleton
    fun bindsMediaInfoSynchronizer(
        mediaInfoSynchronizer: LocalMediaInfoSynchronizer,
    ): MediaInfoSynchronizer

    @Binds
    @Singleton
    fun bindMediaService(
        mediaService: LocalMediaService,
    ): MediaService
}
