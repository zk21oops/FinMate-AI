package dev.atick.storage.room.models

/**
 * Data class representing an analysis of expenses.
 *
 * @property categoryOrMerchant The category or merchant associated with the expenses.
 * @property spending The total spending amount.
 * @property currency The currency of the spending amount.
 * @property maxAmount The maximum amount spent in a single transaction.
 * @property minAmount The minimum amount spent in a single transaction.
 * @property percentage The optional percentage representation of the spending.
 */
data class ExpenseAnalysis(
    val categoryOrMerchant: String,
    val spending: Double,
    val currency: String,
    val maxAmount: Double,
    val minAmount: Double,
    val percentage: Double? = null,
)
