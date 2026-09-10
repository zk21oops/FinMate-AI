package dev.atick.auth.models

import dev.atick.core.ui.utils.TextFieldData

/**
 * Data class representing the input data for an authentication screen.
 *
 * @param name The data for the user's name input field.
 * @param email The data for the user's email input field.
 * @param password The data for the user's password input field.
 */
data class AuthScreenData(
    val name: TextFieldData = TextFieldData(String()),
    val email: TextFieldData = TextFieldData(String()),
    val password: TextFieldData = TextFieldData(String()),
)
