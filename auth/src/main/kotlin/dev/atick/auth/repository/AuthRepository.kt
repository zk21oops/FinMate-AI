package dev.atick.auth.repository

import android.app.Activity

/**
 * Interface defining authentication-related operations.
 */
interface AuthRepository {
    /**
     * Sign in with saved credentials.
     *
     * @param activity The activity instance.
     * @return A [Result] representing the sign-in operation result. It contains [Unit] if
     * the sign-in was successful, or an error if there was a problem.
     */
    suspend fun signInWithSavedCredentials(activity: Activity): Result<Unit>

    /**
     * Sign in with an email and password.
     *
     * @param email The user's email address.
     * @param password The user's password.
     * @return A [Result] representing the sign-in operation result. It contains [Unit] if
     * the sign-in was successful, or an error if there was a problem.
     */
    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<Unit>

    /**
     * Register a new user with an email and password.
     *
     * @param name The user's name.
     * @param email The user's email address.
     * @param password The user's password.
     * @return A [Result] representing the registration operation result. It contains [Unit] if
     * the registration was successful, or an error if there was a problem.
     */
    suspend fun registerWithEmailAndPassword(
        name: String,
        email: String,
        password: String,
        activity: Activity,
    ): Result<Unit>

    /**
     * Sign in with Google.
     *
     * @return A [Result] representing the sign-in operation result. It contains [Unit] if
     * the sign-in was successful, or an error if there was a problem.
     */
    suspend fun signInWithGoogle(activity: Activity): Result<Unit>

    /**
     * Register a new user with Google.
     *
     * @param activity The activity used to launch the Google sign-in intent.
     * @return A [Result] representing the registration operation result. It contains [Unit] if
     * the registration was successful, or an error if there was a problem.
     */
    suspend fun registerWithGoogle(activity: Activity): Result<Unit>
}
