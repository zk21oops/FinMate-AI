package dev.atick.compose.navigation.intro

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.atick.compose.ui.intro.IntroRoute
import kotlinx.serialization.Serializable

/**
 * Represents the intro route.
 */
@Serializable
data object Intro

/**
 * Builds the intro screen.
 *
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.introScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<Intro> {
        IntroRoute(
            onShowSnackbar = onShowSnackbar,
        )
    }
}
