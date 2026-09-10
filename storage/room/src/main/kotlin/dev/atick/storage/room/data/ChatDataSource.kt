package dev.atick.storage.room.data

import dev.atick.storage.room.models.ChatEntity
import kotlinx.coroutines.flow.Flow

/**
 * Interface for accessing and managing chat messages.
 */
interface ChatDataSource {
    /**
     * Retrieves all chat messages.
     *
     * @return A Flow emitting a list of ChatEntity objects representing all chat messages.
     */
    fun getAllMessages(): Flow<List<ChatEntity>>

    /**
     * Retrieves a limited number of recent chat messages.
     *
     * @param limit The maximum number of recent messages to retrieve.
     * @return A list of ChatEntity objects representing the recent chat messages.
     */
    suspend fun getRecentMessages(limit: Int): List<ChatEntity>

    /**
     * Inserts a new chat message.
     *
     * @param chatEntity The ChatEntity object representing the message to be inserted.
     */
    suspend fun insertMessage(chatEntity: ChatEntity)

    /**
     * Deletes a specific chat message.
     *
     * @param chatEntity The ChatEntity object representing the message to be deleted.
     */
    suspend fun deleteMessage(chatEntity: ChatEntity)

    /**
     * Deletes all chat messages.
     */
    suspend fun deleteAllMessages()
}
