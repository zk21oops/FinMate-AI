package dev.atick.gemini.data

/**
 * Interface representing a rate limiter for the Gemini API.
 */
interface GeminiRateLimiter {
    companion object {
        /**
         * The maximum number of requests allowed in the window.
         */
        const val MAX_REQUESTS: Int = 15

        /**
         * The window in milliseconds.
         */
        const val WINDOW_MS: Long = 60000 // 1 minute

        /**
         * The base delay between requests in milliseconds.
         */
        const val BASE_DELAY_BETWEEN_REQUESTS: Long = 2500

        /**
         * The maximum number of retries allowed.
         */
        const val MAX_RETRIES: Int = 3
    }

    /**
     * Checks if the rate limit has been reached and delays the request if necessary.
     */
    suspend fun checkAndDelay()
}
