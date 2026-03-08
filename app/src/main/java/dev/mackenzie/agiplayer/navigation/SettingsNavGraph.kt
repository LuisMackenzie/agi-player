package dev.mackenzie.agiplayer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import dev.mackenzie.agiplayer.settings.Setting
import dev.mackenzie.agiplayer.settings.navigation.aboutPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.appearancePreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.audioPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.decoderPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.folderPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.generalPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.librariesScreen
import dev.mackenzie.agiplayer.settings.navigation.mediaLibraryPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.navigateToAboutPreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToAppearancePreferences
import dev.mackenzie.agiplayer.settings.navigation.gesturePreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.navigateToAudioPreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToDecoderPreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToGesturePreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToFolderPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.navigateToGeneralPreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToLibraries
import dev.mackenzie.agiplayer.settings.navigation.navigateToMediaLibraryPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.navigateToPlayerPreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToSubtitlePreferences
import dev.mackenzie.agiplayer.settings.navigation.navigateToThumbnailPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.playerPreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.settingsNavigationRoute
import dev.mackenzie.agiplayer.settings.navigation.settingsScreen
import dev.mackenzie.agiplayer.settings.navigation.subtitlePreferencesScreen
import dev.mackenzie.agiplayer.settings.navigation.thumbnailPreferencesScreen

const val SETTINGS_ROUTE = "settings_nav_route"

fun NavGraphBuilder.settingsNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = settingsNavigationRoute,
        route = SETTINGS_ROUTE,
    ) {
        settingsScreen(
            onNavigateUp = navController::navigateUp,
            onItemClick = { setting ->
                when (setting) {
                    Setting.APPEARANCE -> navController.navigateToAppearancePreferences()
                    Setting.MEDIA_LIBRARY -> navController.navigateToMediaLibraryPreferencesScreen()
                    Setting.PLAYER -> navController.navigateToPlayerPreferences()
                    Setting.GESTURES -> navController.navigateToGesturePreferences()
                    Setting.DECODER -> navController.navigateToDecoderPreferences()
                    Setting.AUDIO -> navController.navigateToAudioPreferences()
                    Setting.SUBTITLE -> navController.navigateToSubtitlePreferences()
                    Setting.GENERAL -> navController.navigateToGeneralPreferences()
                    Setting.ABOUT -> navController.navigateToAboutPreferences()
                }
            },
        )
        appearancePreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        mediaLibraryPreferencesScreen(
            onNavigateUp = navController::navigateUp,
            onFolderSettingClick = navController::navigateToFolderPreferencesScreen,
            onThumbnailSettingClick = navController::navigateToThumbnailPreferencesScreen,
        )
        thumbnailPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        folderPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        playerPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        gesturePreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        decoderPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        audioPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        subtitlePreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        generalPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        aboutPreferencesScreen(
            onLibrariesClick = navController::navigateToLibraries,
            onNavigateUp = navController::navigateUp,
        )
        librariesScreen(
            onNavigateUp = navController::navigateUp,
        )
    }
}
