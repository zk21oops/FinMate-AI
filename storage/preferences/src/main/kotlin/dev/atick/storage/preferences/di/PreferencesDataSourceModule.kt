package dev.atick.storage.preferences.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.storage.preferences.data.UserPreferencesDataSource
import dev.atick.storage.preferences.data.UserPreferencesDataSourceImpl
import javax.inject.Singleton

/**
 * Preferences DataSource module
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesDataSourceModule {

    /**
     * Bind preferences datasource
     *
     * @param userPreferencesDataSourceImpl PreferencesDatastoreImpl
     * @return [UserPreferencesDataSource]
     */
    @Binds
    @Singleton
    abstract fun bindUserPreferencesDataSource(
        userPreferencesDataSourceImpl: UserPreferencesDataSourceImpl,
    ): UserPreferencesDataSource
}
