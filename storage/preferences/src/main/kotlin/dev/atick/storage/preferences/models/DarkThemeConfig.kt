package dev.atick.storage.preferences.models

import dev.atick.storage.preferences.models.DarkThemeConfig.DARK
import dev.atick.storage.preferences.models.DarkThemeConfig.FOLLOW_SYSTEM
import dev.atick.storage.preferences.models.DarkThemeConfig.LIGHT
import kotlinx.serialization.Serializable

/**
 * Enum class representing configuration options for the dark theme.
 *
 * @property FOLLOW_SYSTEM The dark theme configuration follows the system-wide setting.
 * @property LIGHT The app's dark theme is disabled, using the light theme.
 * @property DARK The app's dark theme is enabled, using the dark theme.
 */
@Serializable
enum class DarkThemeConfig {
    FOLLOW_SYSTEM,
    LIGHT,
    DARK,
}
