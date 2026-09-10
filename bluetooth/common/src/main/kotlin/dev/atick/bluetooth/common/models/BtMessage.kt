package dev.atick.bluetooth.common.models

import java.util.Date

/**
 * Data class representing a Bluetooth message.
 *
 * @property timestamp The timestamp of the message.
 * @property message The content of the message.
 */
data class BtMessage(
    val timestamp: Long = Date().time,
    val message: CharSequence,
)
