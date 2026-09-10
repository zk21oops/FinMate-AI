package dev.atick.gemini.models

import kotlinx.serialization.Serializable

/**
 * Enum class representing the type of recurring expense.
 */
@Serializable
enum class AiRecurringType {
    ONETIME,
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY,
}
