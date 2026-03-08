package dev.mackenzie.agiplayer.feature.videopicker.screens

import dev.mackenzie.agiplayer.core.model.Folder

sealed interface MediaState {
    data object Loading : MediaState
    data class Success(val data: Folder?) : MediaState
}
