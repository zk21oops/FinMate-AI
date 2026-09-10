package dev.atick.gemini.utils

import dev.atick.gemini.models.AiExpense
import kotlinx.serialization.json.Json

/**
 * Utility class to parse JSON strings into [AiExpense] objects.
 */
object ExpenseParser {
    private val json = Json {
        ignoreUnknownKeys = true // Ignore JSON fields that don't match our data class
        coerceInputValues = true // Try to coerce values to the correct type when possible
        encodeDefaults = true // Include default values in JSON output
    }

    /**
     * Parses a JSON string into an [AiExpense] object.
     *
     * @param jsonString The JSON string to parse.
     * @return The parsed [AiExpense] object.
     */
    fun parseExpense(jsonString: String): AiExpense {
        return json.decodeFromString<AiExpense>(jsonString)
    }
}
