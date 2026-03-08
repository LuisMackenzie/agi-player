package dev.mackenzie.agiplayer.core.data.mappers

import dev.mackenzie.agiplayer.core.common.Utils
import dev.mackenzie.agiplayer.core.database.relations.DirectoryWithMedia
import dev.mackenzie.agiplayer.core.database.relations.MediumWithInfo
import dev.mackenzie.agiplayer.core.model.Folder

fun DirectoryWithMedia.toFolder() = Folder(
    name = directory.name,
    path = directory.path,
    dateModified = directory.modified,
    parentPath = directory.parentPath,
    formattedMediaSize = Utils.formatFileSize(media.sumOf { it.mediumEntity.size }),
    mediaList = media.map(MediumWithInfo::toVideo),
)
