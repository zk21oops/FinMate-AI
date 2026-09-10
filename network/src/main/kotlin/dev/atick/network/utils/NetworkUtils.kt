package dev.atick.network.utils

import kotlinx.coroutines.flow.Flow

/**
 * Network utils.
 */
interface NetworkUtils {
    /**
     * Current network state as [Flow].
     */
    val currentState: Flow<NetworkState>
}
