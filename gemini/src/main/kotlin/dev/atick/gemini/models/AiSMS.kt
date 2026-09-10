package dev.atick.gemini.models

import android.icu.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Data class representing an SMS.
 * @param address The sender's phone number.
 * @param body The body of the SMS.
 * @param date The date the SMS was sent.
 */
data class AiSMS(
    val address: String,
    val body: String,
    val date: Long,
) {
    /**
     * Function to get the text of the SMS.
     * @return The text of the SMS.
     */
    fun getTextSMS(): String {
        val dateObject = Date(date)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val formattedDate = dateFormat.format(dateObject)

        return "Sender: $address\nBody: $body\nDate: $formattedDate"
    }
}
