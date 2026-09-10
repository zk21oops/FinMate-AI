package dev.atick.bluetooth.common.utils

import dev.atick.bluetooth.common.models.BtDevice
import dev.atick.bluetooth.common.models.BtState
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface defining Bluetooth utility methods.
 */
interface BluetoothUtils {
    /**
     * Retrieves the current state of Bluetooth.
     *
     * @return A [StateFlow] emitting the current Bluetooth state.
     */
    fun getBluetoothState(): StateFlow<BtState>

    /**
     * Retrieves the list of scanned Bluetooth devices.
     *
     * @return A [StateFlow] emitting the list of scanned Bluetooth devices.
     */
    fun getScannedDevices(): StateFlow<List<BtDevice>>

    /**
     * Retrieves the list of paired Bluetooth devices.
     *
     * @return A [StateFlow] emitting the list of paired Bluetooth devices.
     */
    fun getPairedDevices(): StateFlow<List<BtDevice>>

    /**
     * Stops the Bluetooth device discovery process.
     */
    fun stopDiscovery()
}
