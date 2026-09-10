package dev.atick.compose.worker

import androidx.annotation.RequiresPermission
import kotlinx.coroutines.flow.Flow

/**
 * Interface that provides methods to manage tasks.
 */
interface TaskManager {
    /**
     * Flow that emits a boolean value indicating whether the sync operation is in progress.
     */
    val isSyncing: Flow<Boolean>

    /**
     * Requests a sync operation.
     */
    @RequiresPermission(android.Manifest.permission.READ_SMS)
    fun requestSync()

    /**
     * Schedules a payment reminder for the specified merchant.
     *
     * @param merchantName The name of the merchant.
     * @param nextPaymentDate The next payment date.
     * @param reminderTime The reminder time.
     */
    fun schedulePaymentReminder(
        merchantName: String,
        nextPaymentDate: Long,
        reminderTime: Long,
    )

    /**
     * Schedules a cancellation reminder for the specified merchant.
     *
     * @param merchantName The name of the merchant.
     * @param nextPaymentDate The next payment date.
     * @param reminderTime The reminder time.
     */
    fun scheduleCancellationReminder(
        merchantName: String,
        nextPaymentDate: Long,
        reminderTime: Long,
    )

    /**
     * Shows a warning when the budget exceeds the specified amount.
     *
     * @param budgetAmount The budget amount.
     * @param currentAmount The current amount.
     */
    fun showBudgetExceedWarning(
        budgetAmount: Double,
        currentAmount: Double,
    )
}
