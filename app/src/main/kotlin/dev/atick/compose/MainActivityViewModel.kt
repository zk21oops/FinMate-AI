package dev.atick.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.repository.user.UserDataRepository
import dev.atick.core.extensions.stateInDelayed
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.UiState
import dev.atick.storage.preferences.models.UserData
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

/**
 * Annotates a ViewModel class that is managed by Hilt's dependency injection system.
 *
 * @constructor Creates a [MainActivityViewModel] instance.
 * @param userDataRepository The repository providing access to user data.
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    userDataRepository: UserDataRepository,
) : ViewModel() {

    /**
     * Represents the state of the UI for user data.
     */
    val uiState: StateFlow<UiState<UserData>> = userDataRepository.userData
        .onEach { userData -> Timber.d("User data: $userData") }
        .map { userData -> UiState(userData) }
        .catch { e -> UiState(UserData(), error = OneTimeEvent(e)) }
        .stateInDelayed(UiState(UserData(), loading = true), viewModelScope)
}
