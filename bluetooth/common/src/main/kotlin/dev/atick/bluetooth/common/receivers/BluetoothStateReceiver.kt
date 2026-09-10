package dev.atick.bluetooth.common.receivers

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dev.atick.bluetooth.common.models.BtState

/**
 * BroadcastReceiver for receiving Bluetooth state changes.
 *
 * @param onBtStateChange Callback function to handle Bluetooth state changes.
 */
class BluetoothStateReceiver(
    private val onBtStateChange: (BtState) -> Unit,
) : BroadcastReceiver() {

    /**
     * Called when a broadcast is received.
     *
     * @param context The context of the receiver.
     * @param intent The intent containing the broadcast information.
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)) {
            BluetoothAdapter.STATE_ON -> onBtStateChange(BtState.ENABLED)
            BluetoothAdapter.STATE_OFF -> onBtStateChange(BtState.DISABLED)
        }
    }
}
