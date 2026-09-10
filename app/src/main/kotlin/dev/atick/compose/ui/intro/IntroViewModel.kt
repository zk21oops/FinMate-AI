package dev.atick.compose.ui.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.repository.user.UserDataRepository
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateWith
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {
    private val _introUiState = MutableStateFlow(UiState(Unit))
    val introUiState = _introUiState.asStateFlow()

    fun userFinishedIntro() {
        _introUiState.updateWith(viewModelScope) {
            userDataRepository.userFinishedOnboarding()
        }
    }
}
