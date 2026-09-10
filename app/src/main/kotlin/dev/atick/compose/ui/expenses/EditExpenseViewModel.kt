package dev.atick.compose.ui.expenses

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.expenses.EditExpenseScreenData
import dev.atick.compose.data.expenses.UiCategoryType
import dev.atick.compose.data.expenses.UiExpense
import dev.atick.compose.data.expenses.UiPaymentStatus
import dev.atick.compose.data.expenses.UiRecurringType
import dev.atick.compose.navigation.expenses.EditExpense
import dev.atick.compose.repository.expenses.ExpensesRepository
import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.ui.utils.UiState
import dev.atick.core.ui.utils.updateState
import dev.atick.core.ui.utils.updateStateWith
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EditExpenseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val expenseRepository: ExpensesRepository,
) : ViewModel() {

    private val _expenseUiState = MutableStateFlow(UiState(EditExpenseScreenData()))
    val expenseUiState = _expenseUiState.asStateFlow()

    private val expenseId = checkNotNull(savedStateHandle.toRoute<EditExpense>().expenseId)

    fun setAmount(amount: String) {
        val amountParsed = amount.toDoubleOrNull() ?: 0.0
        _expenseUiState.updateState { copy(amount = amountParsed) }
    }

    fun setCategory(category: UiCategoryType) {
        _expenseUiState.updateState { copy(category = category) }
    }

    fun setPaymentStatus(paymentStatus: UiPaymentStatus) {
        _expenseUiState.updateState { copy(paymentStatus = paymentStatus) }
    }

    fun setRecurringType(recurringType: UiRecurringType) {
        _expenseUiState.updateState { copy(recurringType = recurringType) }
    }

    fun setPaymentDate(paymentDate: Long) {
        _expenseUiState.updateState { copy(paymentDate = paymentDate) }
    }

    fun setDueDate(dueDate: Long) {
        _expenseUiState.updateState { copy(dueDate = dueDate) }
    }

    fun setDescription(description: String) {
        _expenseUiState.updateState { copy(merchant = description) }
    }

    fun setToBeCancelled(toBeCancelled: Boolean) {
        _expenseUiState.updateState { copy(toBeCancelled = toBeCancelled) }
    }

    fun saveExpense() {
        _expenseUiState.updateStateWith(viewModelScope) {
            expenseRepository.updateExpense(
                UiExpense(
                    id = expenseId,
                    amount = expenseUiState.value.data.amount,
                    currency = expenseUiState.value.data.currency,
                    merchant = expenseUiState.value.data.merchant,
                    category = expenseUiState.value.data.category,
                    paymentStatus = expenseUiState.value.data.paymentStatus,
                    recurringType = expenseUiState.value.data.recurringType,
                    paymentDate = expenseUiState.value.data.paymentDate,
                    dueDate = expenseUiState.value.data.dueDate,
                    toBeCancelled = expenseUiState.value.data.toBeCancelled,
                ),
            )
            // TODO: Must be a better way to do this
            Result.success(expenseUiState.value.data.copy(navigateBack = OneTimeEvent(true)))
        }
    }

    fun getExpense() {
        expenseRepository.getExpenseById(expenseId)
            .onEach { expense ->
                _expenseUiState.updateState {
                    copy(
                        amount = expense.amount,
                        currency = expense.currency,
                        merchant = expense.merchant,
                        category = expense.category,
                        paymentStatus = expense.paymentStatus,
                        recurringType = expense.recurringType,
                        paymentDate = expense.paymentDate,
                        dueDate = expense.dueDate,
                        toBeCancelled = expense.toBeCancelled,
                    )
                }
            }
            // .catch { e -> _expenseUiState.update { it.copy(error = OneTimeEvent(e)) } }
            .catch { } // Ignore for now
            .launchIn(viewModelScope)
    }
}
