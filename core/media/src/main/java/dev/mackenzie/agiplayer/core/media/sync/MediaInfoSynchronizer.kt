package dev.mackenzie.agiplayer.core.media.sync

import android.net.Uri

interface MediaInfoSynchronizer {

    fun sync(uri: Uri)

    suspend fun clearThumbnailsCache()
}
