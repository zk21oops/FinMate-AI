package dev.atick.compose.receivers

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import dagger.hilt.android.AndroidEntryPoint
import dev.atick.compose.repository.expenses.ExpensesRepository
import dev.atick.compose.worker.TaskManager
import timber.log.Timber
import javax.inject.Inject

/**
 * A broadcast receiver that listens for incoming SMS messages.
 */
@AndroidEntryPoint
class SmsReceiver @Inject constructor() : BroadcastReceiver() {

    @Inject
    lateinit var taskManager: TaskManager

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle = intent.extras
            if (bundle != null) {
                Telephony.Sms.Intents.getMessagesFromIntent(intent).forEach { sms ->
                    // Check if the SMS is from a bank
                    if (ExpensesRepository.BANK_NAMES.any { sms.originatingAddress?.contains(it) == true }) {
                        Timber.d("SMS Received: ${sms.originatingAddress} - ${sms.messageBody}")
                        @SuppressLint("MissingPermission")
                        // Request a sync to update the expenses
                        taskManager.requestSync()
                    }
                }
            }
        }
    }
}
