package dev.atick.compose.worker

/**
 * Data class that represents the progress of a sync operation.
 *
 * @param total The total number of items to sync.
 * @param current The current number of items synced.
 * @param message The message to display during the sync operation.
 */
data class SyncProgress(
    val total: Int = 0,
    val current: Int = 0,
    val message: String? = null,
)
