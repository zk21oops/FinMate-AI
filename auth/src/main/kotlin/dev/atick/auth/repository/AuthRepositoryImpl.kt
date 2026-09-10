package dev.atick.auth.repository

import android.app.Activity
import dev.atick.auth.data.AuthDataSource
import dev.atick.core.utils.suspendRunCatching
import dev.atick.storage.preferences.data.UserPreferencesDataSource
import javax.inject.Inject

/**
 * Implementation of the [AuthRepository] interface responsible for handling authentication operations.
 *
 * @param authDataSource The data source for authentication operations.
 * @param userPreferencesDataSource The data source for user preferences.
 */
class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : AuthRepository {

    /**
     * Sign in with saved credentials.
     *
     * @param activity The activity instance.
     * @return A [Result] representing the sign-in operation result. It contains [Unit] if
     * the sign-in was successful, or an error if there was a problem.
     */
    override suspend fun signInWithSavedCredentials(activity: Activity): Result<Unit> {
        return suspendRunCatching {
            val user = authDataSource.signInWithSavedCredentials(activity)
            userPreferencesDataSource.setProfile(user.asProfile())
        }
    }

    /**
     * Sign in with an email and password.
     *
     * @param email The user's email address.
     * @param password The user's password.
     * @return A [Result] representing the sign-in operation result. It contains [Unit] if
     * the sign-in was successful, or an error if there was a problem.
     */
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Result<Unit> {
        return suspendRunCatching {
            val user = authDataSource.signInWithEmailAndPassword(email, password)
            userPreferencesDataSource.setProfile(user.asProfile())
        }
    }

    /**
     * Register a new user with an email and password.
     *
     * @param name The user's name.
     * @param email The user's email address.
     * @param password The user's password.
     * @return A [Result] representing the registration operation result. It contains [Unit] if
     * the registration was successful, or an error if there was a problem.
     */
    override suspend fun registerWithEmailAndPassword(
        name: String,
        email: String,
        password: String,
        activity: Activity,
    ): Result<Unit> {
        return suspendRunCatching {
            val user = authDataSource.registerWithEmailAndPassword(name, email, password, activity)
            userPreferencesDataSource.setProfile(user.asProfile())
        }
    }

    /**
     * Sign in with Google.
     *
     * @param activity The current activity.
     * @return A [Result] representing the sign-in operation result. It contains [Unit] if
     * the sign-in was successful, or an error if there was a problem.
     */
    override suspend fun signInWithGoogle(activity: Activity): Result<Unit> {
        return suspendRunCatching {
            val user = authDataSource.signInWithGoogle(activity)
            userPreferencesDataSource.setProfile(user.asProfile())
        }
    }

    /**
     * Register a new user with Google.
     *
     * @param activity The current activity.
     * @return A [Result] representing the registration operation result. It contains [Unit] if
     * the registration was successful, or an error if there was a problem.
     */
    override suspend fun registerWithGoogle(activity: Activity): Result<Unit> {
        return suspendRunCatching {
            val user = authDataSource.registerWithGoogle(activity)
            userPreferencesDataSource.setProfile(user.asProfile())
        }
    }
}
