package dev.atick.gemini.models

import kotlinx.serialization.Serializable

/**
 * Enum class representing the type of currency.
 */
@Serializable
enum class AiCurrencyType {
    QAR,
    USD,
    EUR,
    GBP,
    BDT,
}
