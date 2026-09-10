package dev.atick.sms.models

/**
 * Data class that represents an SMS message.
 *
 * @param id The unique identifier of the SMS message.
 * @param address The address of the sender or recipient of the SMS message.
 * @param body The body of the SMS message.
 * @param date The date and time the SMS message was sent or received.
 * @param type The type of the SMS message.
 */
data class SMSMessage(
    val id: Long,
    val address: String,
    val body: String,
    val date: Long,
    val type: Int,
)
