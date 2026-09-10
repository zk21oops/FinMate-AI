package dev.atick.gemini.data

import dev.atick.gemini.models.AiChatMessage
import dev.atick.gemini.models.AiExpense
import dev.atick.gemini.models.AiSMS

/**
 * Interface representing a data source for the Gemini AI.
 */
interface GeminiDataSource {
    /**
     * Initializes the chat with the given messages and context.
     *
     * @param messages The list of messages to initialize the chat with.
     * @param context The context to initialize the chat with.
     */
    suspend fun initializeChat(messages: List<AiChatMessage>, context: String)

    /**
     * Sends a chat message to the AI.
     *
     * @param message The message to send.
     * @return The response from the AI.
     */
    suspend fun sendChatMessage(message: String): String

    /**
     * Gets an expense from the given SMS.
     *
     * @param aiSMS The SMS to get the expense from.
     * @return The expense from the SMS.
     */
    suspend fun getExpenseFromSMS(aiSMS: AiSMS): AiExpense
}
