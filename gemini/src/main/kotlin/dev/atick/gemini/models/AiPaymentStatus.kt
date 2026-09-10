package dev.atick.gemini.models

import kotlinx.serialization.Serializable

/**
 * Enum class representing the status of a payment.
 */
@Serializable
enum class AiPaymentStatus {
    PENDING,
    PAID,
    OVERDUE,
    CANCELLED,
}
