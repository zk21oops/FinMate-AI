package dev.atick.compose.ui.budgets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.budgets.EditBudgetScreenData
import dev.atick.compose.data.budgets.UiBudget
import dev.atick.compose.repository.budgets.BudgetsRepository
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateState
import dev.atick.core.ui.utils.updateWith
import dev.atick.core.utils.MonthInfo
import dev.atick.core.utils.getMonthInfoAt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EditBudgetViewModel @Inject constructor(
    private val budgetsRepository: BudgetsRepository,
) : ViewModel() {
    private val _editBudgetUiState = MutableStateFlow(UiState(EditBudgetScreenData()))
    val editBudgetUiState = _editBudgetUiState.asStateFlow()

    init {
        refreshBudget(getMonthInfoAt(0))
    }

    fun refreshBudget(monthInfo: MonthInfo) {
        budgetsRepository.getBudgetForMonth(monthInfo.startDate)
            .onEach { budget ->
                _editBudgetUiState.updateState { copy(amount = budget.amount) }
            }
            .catch { e -> _editBudgetUiState.update { it.copy(error = OneTimeEvent(e)) } }
            .launchIn(viewModelScope)
    }

    fun updateAmount(amount: String) {
        _editBudgetUiState.updateState { copy(amount = amount.toDoubleOrNull() ?: 0.0) }
    }

    fun saveBudget(monthInfo: MonthInfo) {
        _editBudgetUiState.updateWith(viewModelScope) {
            val result = budgetsRepository.insertOrUpdateBudget(
                UiBudget(
                    month = monthInfo.startDate,
                    amount = editBudgetUiState.value.data.amount,
                ),
            )
            result.onSuccess {
                _editBudgetUiState.updateState { copy(navigateBack = OneTimeEvent(true)) }
            }
        }
    }
}
