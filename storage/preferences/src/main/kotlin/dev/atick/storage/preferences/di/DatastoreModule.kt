package dev.atick.storage.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.atick.core.di.IoDispatcher
import dev.atick.storage.preferences.models.UserData
import dev.atick.storage.preferences.utils.UserDataSerializer
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * Datastore module
 */
@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    private const val DATA_STORE_FILE_NAME = "user_preferences.json"

    /**
     * Provide preferences datastore
     *
     * @param appContext application context
     * @return DataStore
     */
    @Singleton
    @Provides
    fun providePreferencesDataStore(
        @ApplicationContext appContext: Context,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): DataStore<UserData> {
        return DataStoreFactory.create(
            serializer = UserDataSerializer,
            produceFile = { appContext.dataStoreFile(DATA_STORE_FILE_NAME) },
            scope = CoroutineScope(ioDispatcher + SupervisorJob()),
        )
    }
}
