@file:Suppress("MemberVisibilityCanBePrivate")

package dev.atick.core.utils

// Event wrapper for Single Events
// Details here: https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150

/**
 * A class that represents a single-use event.
 *
 * @param T The type of the event content.
 * @param content The content of the event.
 */
open class SingleLiveEvent<out T>(private val content: T) {

    /**
     * Flag indicating whether the event has been handled.
     */
    var hasBeenHandled = false
        private set

    /**
     * Returns the content if it has not been handled yet.
     *
     * @return The content of the event if it has not been handled, or null if it has been handled.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content regardless of whether it has been handled.
     *
     * @return The content of the event.
     */
    fun peekContent(): T = content
}
