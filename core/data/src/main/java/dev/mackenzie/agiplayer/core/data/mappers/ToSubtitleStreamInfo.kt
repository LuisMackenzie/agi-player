package dev.mackenzie.agiplayer.core.data.mappers

import dev.mackenzie.agiplayer.core.database.entities.SubtitleStreamInfoEntity
import dev.mackenzie.agiplayer.core.model.SubtitleStreamInfo

fun SubtitleStreamInfoEntity.toSubtitleStreamInfo() = SubtitleStreamInfo(
    index = index,
    title = title,
    codecName = codecName,
    language = language,
    disposition = disposition,
)
