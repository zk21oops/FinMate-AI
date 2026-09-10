package dev.atick.compose.ui.expenses

import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.expenses.ExpensesScreenData
import dev.atick.compose.data.expenses.UiExpense
import dev.atick.compose.data.expenses.UiRecurringType
import dev.atick.compose.repository.expenses.ExpensesRepository
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateState
import dev.atick.core.ui.utils.updateWith
import dev.atick.core.utils.MonthInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ExpensesViewModel @Inject constructor(
    private val expensesRepository: ExpensesRepository,
) : ViewModel() {
    private val _expensesUiState = MutableStateFlow(UiState(ExpensesScreenData()))
    val expensesUiState = _expensesUiState.asStateFlow()

    @RequiresPermission(android.Manifest.permission.READ_SMS)
    fun requestSmsSync() {
        _expensesUiState.updateWith(viewModelScope) {
            expensesRepository.requestSync()
        }
    }

    fun refreshExpenses(monthInfo: MonthInfo) {
        expensesRepository.getAllExpenses(monthInfo.startDate, monthInfo.endDate)
            .onEach { expenses ->
                _expensesUiState.updateState { copy(expenses = expenses) }
            }
            .catch { e -> _expensesUiState.update { it.copy(error = OneTimeEvent(e)) } }
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

        _expensesUiState.updateWith(viewModelScope) {
            expensesRepository.setRecurringType(merchant, newRecurringType)
        }
    }

    fun deleteExpense(expense: UiExpense) {
        _expensesUiState.updateWith(viewModelScope) {
            expensesRepository.deleteExpense(expense)
        }
    }
}
