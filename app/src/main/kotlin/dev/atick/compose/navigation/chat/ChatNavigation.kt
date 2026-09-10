package dev.atick.compose.navigation.chat

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.atick.compose.ui.chat.ChatRoute
import dev.atick.core.utils.MonthInfo
import kotlinx.serialization.Serializable

/**
 * Represents the chat route.
 */
@Serializable
data object Chat

/**
 * Navigates to the chat screen.
 *
 * @param navOptions The navigation options.
 */
fun NavController.navigateToChat(navOptions: NavOptions?) {
    navigate(Chat, navOptions)
}

/**
 * Builds the chat screen.
 *
 * @param monthInfo The month information.
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.chatScreen(
    monthInfo: MonthInfo,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<Chat> {
        ChatRoute(
            monthInfo = monthInfo,
            onShowSnackbar = onShowSnackbar,
        )
    }
}
