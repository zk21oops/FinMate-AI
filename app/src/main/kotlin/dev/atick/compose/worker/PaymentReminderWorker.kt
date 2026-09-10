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
import java.util.concurrent.TimeUnit

/**
 * Worker that shows a notification when the payment reminder is due.
 *
 * @param context The application context.
 * @param workerParams The worker parameters.
 * @constructor Creates a new [PaymentReminderWorker] instance.
 * @see CoroutineWorker
 */
@HiltWorker
class PaymentReminderWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
) : CoroutineWorker(context, workerParams) {

    /**
     * Executes the work to show a notification when the payment reminder is due.
     *
     * @return The result of the work.
     */
    override suspend fun doWork(): Result {
        return try {
            Timber.d("PaymentReminderWorker: doWork()")
            val merchantName = inputData.getString(MERCHANT_NAME_KEY)!!
            val nextPaymentDate = inputData.getLong(
                key = NOTIFICATION_TIME_KEY,
                defaultValue = System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000, // 3 days from now
            )
            val notification = context.paymentReminderNotification(
                merchantName = merchantName,
                nextPaymentDate = nextPaymentDate,
            )
            context.showNotification(
                notificationId = PAYMENT_REMINDER_NOTIFICATION_ID,
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
         * Shows a notification when the payment reminder is due.
         *
         * @param merchantName The name of the merchant.
         * @param nextPaymentDate The next payment date.
         * @param reminderTime The time to show the notification.
         * @return The one-time work request to show the notification.
         */
        fun schedulePaymentReminder(
            merchantName: String,
            nextPaymentDate: Long,
            reminderTime: Long,
        ): OneTimeWorkRequest {
            val inputData = listOf(
                MERCHANT_NAME_KEY to merchantName,
                NOTIFICATION_TIME_KEY to nextPaymentDate,
            )
            return OneTimeWorkRequestBuilder<DelegatingWorker>()
                .setInitialDelay(reminderTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .setInputData(PaymentReminderWorker::class.delegatedData(inputData))
                .build()
        }
    }
}
