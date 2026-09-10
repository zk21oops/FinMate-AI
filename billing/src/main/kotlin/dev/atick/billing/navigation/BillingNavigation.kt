package dev.atick.billing.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.atick.billing.ui.BillingRoute
import kotlinx.serialization.Serializable

/**
 * Object for the billing screen destination.
 */
@Serializable
data object Billing

/**
 * Navigates to the billing screen.
 *
 * @param navOptions The navigation options.
 */
fun NavController.navigateToBilling(navOptions: NavOptions? = null) {
    navigate(Billing, navOptions)
}

/**
 * Builds the billing screen.
 *
 * @param onBackClick The on back click callback.
 * @param onShowSnackbar The on show snackbar callback.
 */
fun NavGraphBuilder.billingScreen(
    onBackClick: () -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<Billing> {
        BillingRoute(
            onBackClick = onBackClick,
            onShowSnackbar = onShowSnackbar,
        )
    }
}
