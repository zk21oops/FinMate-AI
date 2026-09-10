package dev.atick.gemini.models

import kotlinx.serialization.Serializable

/**
 * Represents an expense in the AI system.
 *
 * @property amount The amount of the expense.
 * @property currency The currency of the expense.
 * @property merchant The merchant of the expense.
 * @property category The category of the expense.
 * @property paymentStatus The payment status of the expense.
 * @property recurringType The recurring type of the expense.
 * @property paymentDate The payment date of the expense.
 */
@Serializable
data class AiExpense(
    val amount: Double,
    val currency: AiCurrencyType,
    val merchant: String,
    val category: AiExpenseCategory,
    val paymentStatus: AiPaymentStatus = AiPaymentStatus.PENDING,
    val recurringType: AiRecurringType = AiRecurringType.ONETIME,
    val paymentDate: String? = null,
)
