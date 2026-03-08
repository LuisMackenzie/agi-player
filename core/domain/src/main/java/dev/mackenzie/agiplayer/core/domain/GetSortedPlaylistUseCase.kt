package dev.mackenzie.agiplayer.core.domain

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.mackenzie.agiplayer.core.common.Dispatcher
import dev.mackenzie.agiplayer.core.common.NextDispatchers
import dev.mackenzie.agiplayer.core.common.extensions.getPath
import dev.mackenzie.agiplayer.core.data.repository.PreferencesRepository
import dev.mackenzie.agiplayer.core.model.MediaViewMode
import dev.mackenzie.agiplayer.core.model.Video
import java.io.File
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class GetSortedPlaylistUseCase @Inject constructor(
    private val getSortedVideosUseCase: GetSortedVideosUseCase,
    private val preferencesRepository: PreferencesRepository,
    @ApplicationContext private val context: Context,
    @Dispatcher(NextDispatchers.Default) private val defaultDispatcher: CoroutineDispatcher,
) {
    suspend operator fun invoke(uri: Uri): List<Video> = withContext(defaultDispatcher) {
        val path = context.getPath(uri) ?: return@withContext emptyList()
        val parent = File(path).parent.takeIf {
            preferencesRepository.applicationPreferences.first().mediaViewMode != MediaViewMode.VIDEOS
        }

        getSortedVideosUseCase.invoke(parent).first()
    }
}
