package dev.mackenzie.agiplayer.navigation

import android.content.Context
import android.content.Intent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import dev.mackenzie.agiplayer.feature.player.PlayerActivity
import dev.mackenzie.agiplayer.feature.player.utils.PlayerApi
import dev.mackenzie.agiplayer.feature.videopicker.navigation.MediaPickerRoute
import dev.mackenzie.agiplayer.feature.videopicker.navigation.mediaPickerScreen
import dev.mackenzie.agiplayer.feature.videopicker.navigation.navigateToMediaPickerScreen
import dev.mackenzie.agiplayer.feature.videopicker.navigation.navigateToSearch
import dev.mackenzie.agiplayer.feature.videopicker.navigation.searchScreen
import dev.mackenzie.agiplayer.settings.navigation.navigateToSettings
import kotlinx.serialization.Serializable

@Serializable
data object MediaRootRoute

fun NavGraphBuilder.mediaNavGraph(
    context: Context,
    navController: NavHostController,
) {
    navigation<MediaRootRoute>(startDestination = MediaPickerRoute()) {
        mediaPickerScreen(
            onNavigateUp = navController::navigateUp,
            onPlayVideo = { uri ->
                val intent = Intent(context, PlayerActivity::class.java).apply {
                    action = Intent.ACTION_VIEW
                    data = uri
                }
                context.startActivity(intent)
            },
            onPlayVideos = { uris ->
                val intent = Intent(context, PlayerActivity::class.java).apply {
                    action = Intent.ACTION_VIEW
                    data = uris.first()
                    putParcelableArrayListExtra(PlayerApi.API_PLAYLIST, ArrayList(uris))
                }
                context.startActivity(intent)
            },
            onFolderClick = navController::navigateToMediaPickerScreen,
            onSettingsClick = navController::navigateToSettings,
            onSearchClick = navController::navigateToSearch,
        )

        searchScreen(
            onNavigateUp = navController::navigateUp,
            onPlayVideo = { uri ->
                val intent = Intent(context, PlayerActivity::class.java).apply {
                    action = Intent.ACTION_VIEW
                    data = uri
                }
                context.startActivity(intent)
            },
            onFolderClick = navController::navigateToMediaPickerScreen,
        )
    }
}
