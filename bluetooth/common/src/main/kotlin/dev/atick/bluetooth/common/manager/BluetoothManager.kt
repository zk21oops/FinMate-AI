package dev.atick.bluetooth.common.manager

import dev.atick.bluetooth.common.models.BtDevice
import kotlinx.coroutines.flow.StateFlow

/**
 * BluetoothManager interface provides methods to manage Bluetooth connections.
 */
interface BluetoothManager {
    /**
     * Attempts to establish a Bluetooth connection with the specified device address.
     *
     * @param address The address of the Bluetooth device to connect to.
     * @return A [Result] indicating the success or failure of the connection attempt.
     */
    suspend fun connect(address: String): Result<Unit>

    /**
     * Returns the state of the connected Bluetooth device.
     *
     * @return A [StateFlow] emitting the current state of the connected Bluetooth device.
     */
    fun getConnectedDeviceState(): StateFlow<BtDevice?>

    /**
     * Closes the existing Bluetooth connection.
     *
     * @return A [Result] indicating the success or failure of closing the connection.
     */
    suspend fun closeConnection(): Result<Unit>
}
