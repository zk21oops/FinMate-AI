package dev.atick.bluetooth.common.receivers

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import dev.atick.bluetooth.common.models.BtDevice
import dev.atick.bluetooth.common.models.simplify

/**
 * BroadcastReceiver for receiving Bluetooth device discovery events.
 *
 * @param onDeviceFound Callback function to handle discovered Bluetooth devices.
 */
class ScannedDeviceReceiver(
    private val onDeviceFound: (BtDevice) -> Unit,
) : BroadcastReceiver() {

    /**
     * Called when a broadcast is received.
     *
     * @param context The context of the receiver.
     * @param intent The intent containing the broadcast information.
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            BluetoothDevice.ACTION_FOUND -> {
                val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(
                        BluetoothDevice.EXTRA_DEVICE,
                        BluetoothDevice::class.java,
                    )
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                }
                device?.let { onDeviceFound(it.simplify()) }
            }
        }
    }
}
