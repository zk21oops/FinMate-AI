package dev.atick.storage.room.models

/**
 * Data class representing a cumulative expense.
 *
 * @property amount The total amount of the cumulative expense.
 * @property atTime The timestamp of when the cumulative expense was recorded, in milliseconds since epoch.
 */
data class CumulativeExpense(
    val amount: Double,
    val atTime: Long,
)
