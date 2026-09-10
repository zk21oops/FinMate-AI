package dev.atick.storage.preferences.data

import androidx.datastore.core.DataStore
import dev.atick.core.di.IoDispatcher
import dev.atick.storage.preferences.models.DarkThemeConfig
import dev.atick.storage.preferences.models.Profile
import dev.atick.storage.preferences.models.ThemeBrand
import dev.atick.storage.preferences.models.UserData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation of the [UserPreferencesDataSource] interface using DataStore to manage user preferences.
 *
 * @property datastore The DataStore instance to manage user preferences data.
 * @property ioDispatcher The CoroutineDispatcher for performing I/O operations.
 */
class UserPreferencesDataSourceImpl @Inject constructor(
    private val datastore: DataStore<UserData>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : UserPreferencesDataSource {

    /**
     * A [Flow] that emits [UserData] representing user-specific data.
     */
    override val userData: Flow<UserData>
        get() = datastore.data.flowOn(ioDispatcher)

    /**
     * Sets the user profile in the user preferences.
     *
     * @param profile The user [Profile] to be set.
     */
    override suspend fun setProfile(profile: Profile) {
        withContext(ioDispatcher) {
            datastore.updateData { userData ->
                userData.copy(
                    id = profile.id,
                    name = profile.name,
                    profilePictureUriString = profile.profilePictureUriString,
                )
            }
        }
    }

    override suspend fun setLanguage(language: String) {
        withContext(ioDispatcher) {
            datastore.updateData { userData ->
                userData.copy(language = language)
            }
        }
    }

    /**
     * Sets the theme brand in the user preferences.
     *
     * @param themeBrand The theme brand to be set.
     */
    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        withContext(ioDispatcher) {
            datastore.updateData { userData ->
                userData.copy(themeBrand = themeBrand)
            }
        }
    }

    /**
     * Sets the dark theme configuration in the user preferences.
     *
     * @param darkThemeConfig The dark theme configuration to be set.
     */
    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        withContext(ioDispatcher) {
            datastore.updateData { userData ->
                userData.copy(darkThemeConfig = darkThemeConfig)
            }
        }
    }

    /**
     * Sets the dynamic color preferences in the user preferences.
     *
     * @param useDynamicColor A boolean indicating whether dynamic colors should be used.
     */
    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        withContext(ioDispatcher) {
            datastore.updateData { userData ->
                userData.copy(useDynamicColor = useDynamicColor)
            }
        }
    }
}
