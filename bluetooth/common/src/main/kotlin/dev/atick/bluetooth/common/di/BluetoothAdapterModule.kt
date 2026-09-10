package dev.atick.bluetooth.common.di

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BluetoothAdapterModule {
    /**
     * Provides the BluetoothAdapter instance.
     *
     * @param context The application context.
     * @return The BluetoothAdapter instance, or null if Bluetooth is not supported.
     */
    @Provides
    @Singleton
    fun provideBluetoothAdapter(
        @ApplicationContext context: Context,
    ): BluetoothAdapter? {
        val bluetoothManager = context.getSystemService(BluetoothManager::class.java)
        return bluetoothManager?.adapter
    }
}
