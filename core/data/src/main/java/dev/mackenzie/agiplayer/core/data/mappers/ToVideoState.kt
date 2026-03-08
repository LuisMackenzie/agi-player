package dev.mackenzie.agiplayer.core.data.mappers

import dev.mackenzie.agiplayer.core.data.models.VideoState
import dev.mackenzie.agiplayer.core.database.converter.UriListConverter
import dev.mackenzie.agiplayer.core.database.entities.MediumStateEntity

fun MediumStateEntity.toVideoState(): VideoState {
    return VideoState(
        path = uriString,
        position = playbackPosition.takeIf { it != 0L },
        audioTrackIndex = audioTrackIndex,
        subtitleTrackIndex = subtitleTrackIndex,
        playbackSpeed = playbackSpeed,
        externalSubs = UriListConverter.fromStringToList(externalSubs),
        videoScale = videoScale,
        subtitleDelayMilliseconds = subtitleDelayMilliseconds,
        subtitleSpeed = subtitleSpeed,
    )
}
