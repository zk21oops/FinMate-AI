package dev.atick.gemini.models

import kotlinx.serialization.Serializable

/**
 * Enum class representing the category of an expense.
 */
@Serializable
enum class AiExpenseCategory {
    FOOD,
    ESSENTIAL,
    LIFESTYLE,
    TRANSPORTATION,
    HEALTHCARE,
    SAVINGS,
    DEBT,
    EDUCATION,
    OTHERS,
}
