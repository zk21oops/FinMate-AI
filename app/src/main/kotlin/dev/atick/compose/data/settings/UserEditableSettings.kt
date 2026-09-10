package dev.atick.compose.data.settings

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Translate
import androidx.compose.ui.graphics.vector.ImageVector
import dev.atick.compose.R
import dev.atick.storage.preferences.models.DarkThemeConfig
import dev.atick.storage.preferences.models.ThemeBrand

/**
 * Data class representing editable user settings related to themes and appearance.
 *
 * @property language The preferred ui language.
 * @property brand The selected brand for the theme.
 * @property useDynamicColor Indicates whether dynamic colors are enabled.
 * @property darkThemeConfig Configuration for the dark theme.
 * @constructor Creates a [UserEditableSettings] instance with optional parameters.
 */
data class UserEditableSettings(
    val language: String = Language.ENGLISH.code,
    val brand: ThemeBrand = ThemeBrand.DEFAULT,
    val useDynamicColor: Boolean = true,
    val darkThemeConfig: DarkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM,
)

/**
 * Enum class representing the supported languages.
 *
 * @property code The language code.
 * @property title The string resource id for the language title.
 * @property icon The icon for the language.
 */
enum class Language(val code: String, @StringRes val title: Int, val icon: ImageVector) {
    ENGLISH("en", R.string.en, Icons.Default.Language),
    ARABIC("ar", R.string.ar, Icons.Default.Translate),
}
