package dev.atick.compose.data.subscriptions

import dev.atick.compose.data.expenses.UiExpense

/**
 * Data class representing the subscriptions screen data.
 * @param subscriptions The list of subscriptions.
 */
data class SubscriptionsScreenData(
    val subscriptions: List<UiExpense> = emptyList(),
)
