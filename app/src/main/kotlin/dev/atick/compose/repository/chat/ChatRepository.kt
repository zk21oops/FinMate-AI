package dev.atick.compose.repository.chat

import dev.atick.compose.data.chat.UiMessage
import dev.atick.core.utils.MonthInfo
import kotlinx.coroutines.flow.Flow

/**
 * Repository for fetching chat data.
 */
interface ChatRepository {
    companion object {
        /**
         * The maximum depth of the chat history to fetch.
         */
        const val MAX_HISTORY_DEPTH = 100

        /**
         * The number of top categories to load.
         */
        const val N_TOP_CATEGORY_TO_LOAD = 10

        /**
         * The number of top merchants to load.
         */
        const val N_TOP_MERCHANT_TO_LOAD = 10
    }

    /**
     * Gets all the messages.
     *
     * @return A [Flow] of [List] of [UiMessage] representing the messages.
     */
    fun getAllMessages(): Flow<List<UiMessage>>

    /**
     * Initializes the chat.
     *
     * @param monthInfo The month information for which the chat is to be initialized.
     * @param historyDepth The depth of the chat history to fetch.
     * @return A [Result] indicating the success or failure of the operation.
     */
    suspend fun initializeChat(monthInfo: MonthInfo, historyDepth: Int): Result<Unit>

    /**
     * Sends a message.
     *
     * @param message The message to be sent.
     * @return A [Result] indicating the success or failure of the operation.
     */
    suspend fun sendMessage(message: String): Result<Unit>
}
