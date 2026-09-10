package dev.atick.sms.data

import androidx.annotation.RequiresPermission
import dev.atick.sms.models.SMSMessage

/**
 * Interface for a data source that provides SMS messages.
 */
interface SMSDataSource {
    /**
     * Queries SMS messages based on the provided parameters.
     * @param senderNames The names of the senders to filter by.
     * @param keywords The keywords to filter by.
     * @param ignoreWords The words to ignore.
     * @param startDate The start date to filter by.
     * @param endDate The end date to filter by.
     * @return The list of SMS messages that match the provided parameters.
     */
    @RequiresPermission(android.Manifest.permission.READ_SMS)
    suspend fun querySMS(
        senderNames: List<String>,
        keywords: List<String>? = null,
        ignoreWords: List<String>? = null,
        startDate: Long? = null,
        endDate: Long = System.currentTimeMillis(),
    ): List<SMSMessage>
}
