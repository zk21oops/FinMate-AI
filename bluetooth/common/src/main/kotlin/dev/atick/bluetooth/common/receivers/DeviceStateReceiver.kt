@file:Suppress("DEPRECATION")

package dev.atick.bluetooth.common.receivers

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import dev.atick.bluetooth.common.models.BtDevice
import dev.atick.bluetooth.common.models.simplify

/**
 * BroadcastReceiver for receiving Bluetooth device connection state changes.
 *
 * @param onConnectionStateChange Callback function to handle Bluetooth device connection state changes.
 */
class DeviceStateReceiver(
    private val onConnectionStateChange: (BtDevice) -> Unit,
) : BroadcastReceiver() {

    /**
     * Called when a broadcast is received.
     *
     * @param context The context of the receiver.
     * @param intent The intent containing the broadcast information.
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(
                BluetoothDevice.EXTRA_DEVICE,
                BluetoothDevice::class.java,
            )
        } else {
            intent?.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
        }
        if (device == null) return
        when (intent?.action) {
            BluetoothDevice.ACTION_ACL_CONNECTED -> {
                onConnectionStateChange(device.simplify(true))
            }

            BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                onConnectionStateChange(device.simplify(false))
            }
        }
    }
}
