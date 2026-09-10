package dev.atick.compose

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.atick.compose.worker.Sync
import dev.atick.core.extensions.hasPermission
import timber.log.Timber

/**
 * The main application class that extends [Application] and is annotated with [HiltAndroidApp].
 */
@HiltAndroidApp
class App : Application() {

    /**
     * Called when the application is first created.
     * Performs initialization tasks, such as setting up Timber logging in debug mode.
     */
    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        if (hasPermission(Manifest.permission.READ_SMS)) Sync.initialize(this)
    }
}
