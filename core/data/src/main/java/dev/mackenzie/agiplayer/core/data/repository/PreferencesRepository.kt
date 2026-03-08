package dev.mackenzie.agiplayer.core.data.repository

import dev.mackenzie.agiplayer.core.model.ApplicationPreferences
import dev.mackenzie.agiplayer.core.model.PlayerPreferences
import kotlinx.coroutines.flow.StateFlow

interface PreferencesRepository {

    /**
     * Stream of [ApplicationPreferences].
     */
    val applicationPreferences: StateFlow<ApplicationPreferences>

    /**
     * Stream of [PlayerPreferences].
     */
    val playerPreferences: StateFlow<PlayerPreferences>

    suspend fun updateApplicationPreferences(
        transform: suspend (ApplicationPreferences) -> ApplicationPreferences,
    )

    suspend fun updatePlayerPreferences(transform: suspend (PlayerPreferences) -> PlayerPreferences)

    suspend fun resetPreferences()
}
