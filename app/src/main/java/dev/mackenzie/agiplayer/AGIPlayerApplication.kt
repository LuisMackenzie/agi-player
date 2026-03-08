package dev.mackenzie.agiplayer

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import dagger.hilt.android.HiltAndroidApp
import dev.mackenzie.agiplayer.core.common.di.ApplicationScope
import dev.mackenzie.agiplayer.core.data.repository.PreferencesRepository
import dev.mackenzie.agiplayer.crash.CrashActivity
import dev.mackenzie.agiplayer.crash.GlobalExceptionHandler
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope

@HiltAndroidApp
class AGIPlayerApplication : Application(), SingletonImageLoader.Factory {

    @Inject
    lateinit var preferencesRepository: PreferencesRepository

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    @ApplicationScope
    lateinit var applicationScope: CoroutineScope

    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler(GlobalExceptionHandler(applicationContext, CrashActivity::class.java))
    }

    override fun newImageLoader(context: PlatformContext): ImageLoader = imageLoader
}
