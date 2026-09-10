package dev.atick.storage.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.atick.storage.room.models.ChatEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for the messages table.
 */
@Dao
interface ChatDao {
    /**
     * Returns a [Flow] of [ChatEntity] representing all the messages in the messages table.
     *
     * @return A [Flow] of [ChatEntity] representing all the messages in the messages table.
     */
    @Query("SELECT * FROM messages ORDER BY timestamp ASC")
    fun getAllMessages(): Flow<List<ChatEntity>>

    /**
     * Returns a [Flow] of [ChatEntity] representing the message with the given ID.
     *
     * @param id The ID of the message to be retrieved.
     * @return A [Flow] of [ChatEntity] representing the message with the given ID.
     */
    @Query("SELECT * FROM messages ORDER BY timestamp DESC LIMIT :limit")
    suspend fun getRecentMessages(limit: Int): List<ChatEntity>

    /**
     * Inserts the given [ChatEntity] in the messages table.
     *
     * @param chatEntity The [ChatEntity] to be inserted.
     */
    @Insert
    suspend fun insertMessage(chatEntity: ChatEntity)

    /**
     * Deletes the given [ChatEntity] from the messages table.
     *
     * @param chatEntity The [ChatEntity] to be deleted.
     */
    @Delete
    suspend fun deleteMessage(chatEntity: ChatEntity)

    /**
     * Deletes all the messages from the messages table.
     */
    @Query("DELETE FROM messages")
    suspend fun deleteAllMessages()
}
