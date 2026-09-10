package dev.atick.storage.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing a chat message in the database.
 *
 * @property id The unique identifier for the chat message, auto-generated.
 * @property text The content of the chat message.
 * @property isFromUser A flag indicating whether the message is from the user.
 * @property timestamp The timestamp of when the message was created, in milliseconds since epoch.
 */
@Entity(tableName = "messages")
data class ChatEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val text: String,
    val isFromUser: Boolean = true,
    val timestamp: Long = System.currentTimeMillis(),
)
