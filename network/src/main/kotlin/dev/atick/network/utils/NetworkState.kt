package dev.atick.network.utils

import androidx.annotation.StringRes
import dev.atick.network.R

/**
 * Network state.
 *
 * @param description [StringRes] description.
 */
enum class NetworkState(@StringRes val description: Int) {
    /**
     * Network is connected.
     */
    CONNECTED(R.string.network_connected),

    /**
     * Network is connecting.
     */
    LOSING(R.string.network_losing),

    /**
     * Network is disconnected.
     */
    LOST(R.string.network_lost),

    /**
     * Network is unavailable.
     */
    UNAVAILABLE(R.string.network_not_available),
}
