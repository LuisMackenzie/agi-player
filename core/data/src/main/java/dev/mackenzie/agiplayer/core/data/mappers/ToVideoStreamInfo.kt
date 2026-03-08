package dev.mackenzie.agiplayer.core.data.mappers

import dev.mackenzie.agiplayer.core.database.entities.VideoStreamInfoEntity
import dev.mackenzie.agiplayer.core.model.VideoStreamInfo

fun VideoStreamInfoEntity.toVideoStreamInfo() = VideoStreamInfo(
    index = index,
    title = title,
    codecName = codecName,
    language = language,
    disposition = disposition,
    bitRate = bitRate,
    frameRate = frameRate,
    frameWidth = frameWidth,
    frameHeight = frameHeight,
)
