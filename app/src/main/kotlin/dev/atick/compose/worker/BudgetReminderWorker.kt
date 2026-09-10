package dev.atick.compose.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dev.atick.core.extensions.showNotification
import timber.log.Timber

/**
 * Worker that shows a notification when the budget amount is exceeded.
 *
 * @param context The application context.
 * @param workerParams The worker parameters.
 * @constructor Creates a new [BudgetReminderWorker] instance.
 * @see CoroutineWorker
 */
@HiltWorker
class BudgetReminderWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
) : CoroutineWorker(context, workerParams) {

    /**
     * Executes the work to show a notification when the budget amount is exceeded.
     *
     * @return The result of the work.
     */
    override suspend fun doWork(): Result {
        return try {
            val budgetAmount = inputData.getDouble(BUDGET_AMOUNT_KEY, 0.0)
            val currentAmount = inputData.getDouble(CURRENT_AMOUNT_KEY, 0.0)
            if (budgetAmount == 0.0 || currentAmount == 0.0) {
                Timber.e("Budget amount or current amount not provided")
                return Result.failure()
            }
            val notification = context.budgetExceedNotification(
                budgetAmount = budgetAmount,
                currentAmount = currentAmount,
            )
            context.showNotification(
                notificationId = BUDGET_EXCEED_NOTIFICATION_ID,
                notification = notification,
            )
            Result.success()
        } catch (e: Exception) {
            Timber.e(e)
            Result.failure()
        }
    }

    companion object {
        /**
         * Shows a notification when the budget amount is exceeded.
         *
         * @param budgetAmount The budget amount.
         * @param currentAmount The current amount.
         * @return A [OneTimeWorkRequest] to show the notification.
         */
        fun showBudgetExceedWarning(
            budgetAmount: Double,
            currentAmount: Double,
        ): OneTimeWorkRequest {
            val inputData = listOf(
                BUDGET_AMOUNT_KEY to budgetAmount,
                CURRENT_AMOUNT_KEY to currentAmount,
            )
            return OneTimeWorkRequestBuilder<DelegatingWorker>()
                .setInputData(BudgetReminderWorker::class.delegatedData(inputData))
                .build()
        }
    }
}
