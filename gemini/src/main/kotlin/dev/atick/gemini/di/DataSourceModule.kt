package dev.atick.gemini.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.gemini.data.GeminiDataSource
import dev.atick.gemini.data.GeminiDataSourceImpl
import javax.inject.Singleton

/**
 * Dagger module that provides the binding for the [GeminiDataSource] interface.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    /**
     * Binds the [GeminiDataSourceImpl] implementation to the [GeminiDataSource] interface.
     *
     * @param dataSource The implementation of [GeminiDataSource] to be bound.
     * @return The [GeminiDataSource] interface.
     */
    @Binds
    @Singleton
    abstract fun bindGeminiDataSource(dataSource: GeminiDataSourceImpl): GeminiDataSource
}
