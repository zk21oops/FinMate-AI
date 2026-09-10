package dev.atick.compose.data.budgets

import dev.atick.core.ui.utils.OneTimeEvent
import dev.atick.core.utils.getMonthInfoAt

/**
 * Data class representing the edit budget screen data.
 * @param month The timestamp of the start date of the month.
 * @param amount The budget amount.
 * @param navigateBack The event to navigate back.
 */
data class EditBudgetScreenData(
    val month: Long = getMonthInfoAt(0).startDate, // The timestamp of the start date of the month
    val amount: Double? = null,
    val navigateBack: OneTimeEvent<Boolean> = OneTimeEvent(false),
)
