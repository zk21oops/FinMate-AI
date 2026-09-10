package dev.atick.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing Firebase Authentication-related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object FirebaseAuthModule {

    /**
     * Provides a singleton instance of [FirebaseAuth].
     *
     * @return An instance of [FirebaseAuth] for authentication operations.
     */
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }
}
