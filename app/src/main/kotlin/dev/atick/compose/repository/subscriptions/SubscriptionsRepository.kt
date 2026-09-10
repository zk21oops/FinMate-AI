package dev.atick.compose.repository.subscriptions

import dev.atick.compose.data.expenses.UiExpense
import kotlinx.coroutines.flow.Flow

/**
 * Repository for fetching subscription data.
 */
interface SubscriptionsRepository {
    companion object {
        /**
         * The time before reminding user for cancellation.
         */
        const val CANCELLATION_REMINDER_TIME = 3 * 24 * 60 * 60 * 1000L
    }

    /**
     * Gets the subscriptions.
     *
     * @return A [Flow] of [List] of [UiExpense] representing the subscriptions.
     */
    fun getSubscriptions(): Flow<List<UiExpense>>

    /**
     * Sets the subscription to be cancelled.
     *
     * @param merchant The merchant for which the subscription is to be cancelled.
     * @param toBeCancelled The flag indicating if the subscription is to be cancelled.
     * @return A [Result] indicating the success or failure of the operation.
     */
    suspend fun setCancellation(merchant: String, toBeCancelled: Boolean): Result<Unit>
}
