package dev.atick.storage.preferences.models

import kotlinx.serialization.Serializable

/**
 * Represents user data.
 *
 * This data class is used to store information about a user, including their ID, name, profile picture URI string,
 * preferred theme brand, dark theme configuration, and dynamic color preference.
 *
 * @property id The unique identifier for the user. Defaults to empty if not provided.
 * @property name The name of the user. Defaults to "No Name" if not provided.
 * @property profilePictureUriString The URI string for the user's profile picture, if available. Defaults to `null` if not provided.
 * @property language The preferred language for the user.
 * @property themeBrand The preferred theme brand for the user. Defaults to [ThemeBrand.DEFAULT].
 * @property darkThemeConfig The user's preferred dark theme configuration. Defaults to [DarkThemeConfig.FOLLOW_SYSTEM].
 * @property useDynamicColor A boolean indicating whether the user prefers dynamic colors. Defaults to `true`.
 */
@Serializable
data class UserData(
    val id: String = String(),
    val name: String = "Anonymous",
    val profilePictureUriString: String? = null,
    val language: String = "en",
    val themeBrand: ThemeBrand = ThemeBrand.DEFAULT,
    val darkThemeConfig: DarkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM,
    val useDynamicColor: Boolean = true,
)
