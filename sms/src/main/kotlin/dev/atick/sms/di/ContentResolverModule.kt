package dev.atick.sms.di

import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger module that provides the [ContentResolver] dependency.
 */
@Module
@InstallIn(SingletonComponent::class)
object ContentResolverModule {

    /**
     * Provides the [ContentResolver] dependency.
     *
     * @param context The application context.
     * @return The [ContentResolver] instance.
     */
    @Provides
    @Singleton
    fun provideContentResolver(
        @ApplicationContext context: Context,
    ): ContentResolver {
        return context.contentResolver
    }
}
