package dev.atick.gemini.models

import com.google.firebase.ai.type.Content
import com.google.firebase.ai.type.content

/**
 * Data class representing a chat message.
 * @param text The text of the message.
 * @param sender The sender of the message.
 */
data class AiChatMessage(
    val text: String,
    val sender: AiChatSender,
)

/**
 * Converter function to convert an [AiChatMessage] to a [Content].
 * @return The converted [Content].
 */
fun AiChatMessage.toGeminiContent(): Content {
    return content(
        role = if (sender == AiChatSender.USER) "user" else "model",
    ) { text(text) }
}

/**
 * Converter function to convert a list of [AiChatMessage] to a list of [Content].
 */
fun List<AiChatMessage>.toGeminiContents(): List<Content> {
    return map { it.toGeminiContent() }
}
