package dev.atick.compose.ui.subscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.expenses.UiRecurringType
import dev.atick.compose.data.subscriptions.SubscriptionsScreenData
import dev.atick.compose.repository.expenses.ExpensesRepository
import dev.atick.compose.repository.subscriptions.SubscriptionsRepository
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateState
import dev.atick.core.ui.utils.updateWith
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    private val subscriptionsRepository: SubscriptionsRepository,
    private val expensesRepository: ExpensesRepository,
) : ViewModel() {
    private val _subscriptionsUiState = MutableStateFlow(UiState(SubscriptionsScreenData()))
    val subscriptionsUiState = _subscriptionsUiState.asStateFlow()

    init {
        refreshSubscriptions()
    }

    fun refreshSubscriptions() {
        subscriptionsRepository.getSubscriptions()
            .onEach { subscriptions ->
                _subscriptionsUiState.updateState { copy(subscriptions = subscriptions) }
            }
            .catch { e -> _subscriptionsUiState.update { it.copy(error = OneTimeEvent(e)) } }
            .launchIn(viewModelScope)
    }

    fun setRecurringType(merchant: String, recurringType: UiRecurringType) {
        val newRecurringType = when (recurringType) {
            UiRecurringType.ONETIME -> UiRecurringType.DAILY
            UiRecurringType.DAILY -> UiRecurringType.WEEKLY
            UiRecurringType.WEEKLY -> UiRecurringType.MONTHLY
            UiRecurringType.MONTHLY -> UiRecurringType.YEARLY
            UiRecurringType.YEARLY -> UiRecurringType.ONETIME
        }

        _subscriptionsUiState.updateWith(viewModelScope) {
            expensesRepository.setRecurringType(merchant, newRecurringType)
        }
    }

    fun setCancellation(merchant: String, toBeCancelled: Boolean) {
        _subscriptionsUiState.updateWith(viewModelScope) {
            subscriptionsRepository.setCancellation(merchant, toBeCancelled)
        }
    }
}
