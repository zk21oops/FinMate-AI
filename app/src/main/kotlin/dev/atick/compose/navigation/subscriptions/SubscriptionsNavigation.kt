package dev.atick.compose.navigation.subscriptions

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.atick.compose.ui.subscriptions.SubscriptionsRoute
import kotlinx.serialization.Serializable

/**
 * Represents the subscriptions route.
 */
@Serializable
data object Subscriptions

/**
 * Navigates to the subscriptions screen.
 *
 * @param navOptions The navigation options.
 */
fun NavController.navigateToSubscriptions(navOptions: NavOptions? = null) {
    navigate(Subscriptions, navOptions)
}

/**
 * Builds the subscriptions screen.
 *
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.subscriptionsScreen(
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<Subscriptions> {
        SubscriptionsRoute(
            onShowSnackbar = onShowSnackbar,
        )
    }
}
