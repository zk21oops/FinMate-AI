package dev.atick.bluetooth.common.data

import dev.atick.bluetooth.common.models.BtMessage
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface representing a Bluetooth data source.
 */
interface BluetoothDataSource {
    /**
     * Returns the state flow of Bluetooth messages received from the connected device.
     *
     * @return The state flow of Bluetooth messages.
     */
    fun getBluetoothDataStream(): StateFlow<BtMessage?>

    /**
     * Sends data to the connected Bluetooth device.
     *
     * @param data The data to send.
     * @return A result indicating the success or failure of sending the data.
     */
    suspend fun sendDataToBluetoothDevice(data: String): Result<Unit>
}
