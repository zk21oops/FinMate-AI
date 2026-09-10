package dev.atick.storage.preferences.models

import dev.atick.storage.preferences.models.ThemeBrand.ANDROID
import dev.atick.storage.preferences.models.ThemeBrand.DEFAULT
import kotlinx.serialization.Serializable

/**
 * Enum class representing different brand options for the app's theme.
 *
 * @property DEFAULT The default brand option for the app's theme.
 * @property ANDROID The brand option representing the Android platform theme.
 */
@Serializable
enum class ThemeBrand {
    DEFAULT,
    ANDROID,
}
