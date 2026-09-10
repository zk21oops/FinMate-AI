package dev.atick.billing.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.billing.repository.BillingRepository
import dev.atick.billing.repository.BillingRepositoryImpl
import javax.inject.Singleton

/**
 * Module for providing repositories.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    /**
     * Binds the [BillingRepositoryImpl] to the [BillingRepository] interface.
     *
     * @param billingRepositoryImpl The implementation of the [BillingRepository] interface.
     * @return The [BillingRepository] interface.
     */
    @Binds
    @Singleton
    abstract fun binBillingRepository(
        billingRepositoryImpl: BillingRepositoryImpl,
    ): BillingRepository
}
