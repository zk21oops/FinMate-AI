package dev.atick.sms.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.sms.data.SMSDataSource
import dev.atick.sms.data.SMSDataSourceImpl
import javax.inject.Singleton

/**
 * Dagger module that provides the binding for the [SMSDataSource] interface.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    /**
     * Binds the [SMSDataSourceImpl] implementation to the [SMSDataSource] interface.
     *
     * @param smsDataSourceImpl The implementation of [SMSDataSource] to be bound.
     * @return The [SMSDataSource] interface.
     */
    @Binds
    @Singleton
    abstract fun bindSMSDataSource(
        smsDataSourceImpl: SMSDataSourceImpl,
    ): SMSDataSource
}
