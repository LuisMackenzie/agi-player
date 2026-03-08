package dev.mackenzie.agiplayer.core.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.mackenzie.agiplayer.core.database.entities.DirectoryEntity
import dev.mackenzie.agiplayer.core.database.entities.MediumEntity

data class DirectoryWithMedia(
    @Embedded val directory: DirectoryEntity,
    @Relation(
        entity = MediumEntity::class,
        parentColumn = "path",
        entityColumn = "parent_path",
    )
    val media: List<MediumWithInfo>,
)
