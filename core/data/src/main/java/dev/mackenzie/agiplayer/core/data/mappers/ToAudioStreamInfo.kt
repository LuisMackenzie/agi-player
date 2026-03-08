package dev.mackenzie.agiplayer.core.data.mappers

import dev.mackenzie.agiplayer.core.database.entities.AudioStreamInfoEntity
import dev.mackenzie.agiplayer.core.model.AudioStreamInfo

fun AudioStreamInfoEntity.toAudioStreamInfo() = AudioStreamInfo(
    index = index,
    title = title,
    codecName = codecName,
    language = language,
    disposition = disposition,
    bitRate = bitRate,
    sampleFormat = sampleFormat,
    sampleRate = sampleRate,
    channels = channels,
    channelLayout = channelLayout,
)
