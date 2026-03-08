package dev.mackenzie.agiplayer.feature.videopicker.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.mackenzie.agiplayer.core.model.MediaLayoutMode
import dev.mackenzie.agiplayer.core.ui.R

@Composable
fun MediaLayoutMode.name(): String {
    return when (this) {
        MediaLayoutMode.LIST -> stringResource(id = R.string.list)
        MediaLayoutMode.GRID -> stringResource(id = R.string.grid)
    }
}
