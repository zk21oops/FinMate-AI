package dev.atick.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

/**
 * Dagger module that provides a coroutine scope for the application.
 */
@Module(
    includes = [
        DispatcherModule::class,
    ],
)
@InstallIn(SingletonComponent::class)
object CoroutineScopeModule {

    /**
     * Provides a coroutine scope for the application.
     *
     * @return The coroutine scope for the application.
     */
    @Provides
    @Singleton
    @ApplicationScope
    fun provideCoroutineScope(
        @IoDispatcher dispatcher: CoroutineDispatcher,
    ): CoroutineScope =
        CoroutineScope(SupervisorJob() + dispatcher)
}
