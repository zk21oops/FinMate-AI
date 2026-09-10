package dev.atick.bluetooth.classic.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.bluetooth.classic.BluetoothClassic
import dev.atick.bluetooth.common.data.BluetoothDataSource
import dev.atick.bluetooth.common.manager.BluetoothManager
import dev.atick.bluetooth.common.utils.BluetoothUtils
import javax.inject.Singleton

/**
 * Dagger module for providing Bluetooth Classic related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class BluetoothClassicModule {

    /**
     * Binds [BluetoothClassic] implementation to [BluetoothUtils] interface.
     *
     * @param bluetoothClassic The Bluetooth Classic implementation.
     * @return The BluetoothUtils interface.
     */
    @Binds
    @Singleton
    abstract fun provideBluetoothUtils(
        bluetoothClassic: BluetoothClassic,
    ): BluetoothUtils

    /**
     * Binds [BluetoothClassic] implementation to [BluetoothManager] interface.
     *
     * @param bluetoothClassic The Bluetooth Classic implementation.
     * @return The BluetoothManager interface.
     */
    @Binds
    @Singleton
    abstract fun bindBluetoothManager(
        bluetoothClassic: BluetoothClassic,
    ): BluetoothManager

    /**
     * Binds [BluetoothClassic] implementation to [BluetoothDataSource] interface.
     *
     * @param bluetoothClassic The Bluetooth Classic implementation.
     * @return The BluetoothDataSource interface.
     */
    @Binds
    @Singleton
    abstract fun bindBluetoothDataSource(
        bluetoothClassic: BluetoothClassic,
    ): BluetoothDataSource
}
