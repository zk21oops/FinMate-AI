package dev.atick.compose.worker

import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dev.atick.compose.repository.expenses.ExpensesRepository
import dev.atick.core.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Worker that syncs expenses from SMS.
 *
 * @param context The application context.
 * @param workerParams The worker parameters.
 * @param ioDispatcher The IO dispatcher.
 * @param expensesRepository The expenses repository.
 * @constructor Creates a new [SyncWorker] instance.
 * @see CoroutineWorker
 */
@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val expensesRepository: ExpensesRepository,
) : CoroutineWorker(context, workerParams) {

    /**
     * Provides the foreground information for the worker.
     * @return The foreground information.
     */
    override suspend fun getForegroundInfo(): ForegroundInfo {
        Timber.d("SyncWorker: getForegroundInfo")
        return context.syncForegroundInfo(0, 0)
    }

    /**
     * Provides the foreground information for the worker.
     * @param total The total number of items.
     * @param current The current number of items.
     * @return The foreground information.
     */
    private fun getForegroundInfo(total: Int, current: Int): ForegroundInfo {
        return context.syncForegroundInfo(total, current)
    }

    /**
     * Executes the work to sync expenses from SMS.
     * @return The result of the work.
     */
    @RequiresPermission(android.Manifest.permission.READ_SMS)
    override suspend fun doWork(): Result {
        return withContext(ioDispatcher) {
            try {
                setForeground(getForegroundInfo())
                expensesRepository.syncExpensesFromSms()
                    .flowOn(ioDispatcher)
                    .collect { progress ->
                        Timber.d("SyncWorker: Progress: $progress")
                        setForeground(
                            foregroundInfo = getForegroundInfo(
                                total = progress.total,
                                current = progress.current,
                            ),
                        )
                    }
                Result.success()
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }

    companion object {
        /**
         * Starts the work to sync expenses from SMS.
         * @return The one-time work request to sync expenses from SMS.
         */
        @RequiresPermission(android.Manifest.permission.READ_SMS)
        fun startUpSyncWork(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<DelegatingWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .setConstraints(SyncConstraints)
                .setInputData(SyncWorker::class.delegatedData())
                .build()
        }
    }
}
