package dev.atick.compose.navigation.budgets

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.atick.compose.ui.budgets.EditBudgetRoute
import dev.atick.core.utils.MonthInfo
import kotlinx.serialization.Serializable

/**
 * Represents the edit budget route.
 */
@Serializable
data object EditBudget

/**
 * Navigates to the edit budget screen.
 */
fun NavController.navigateToEditBudgetScreen() {
    navigate(EditBudget) { launchSingleTop = true }
}

/**
 * Builds the edit budget screen.
 *
 * @param monthInfo The month information.
 * @param onBackClick The callback to handle the back click.
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.editBudgetScreen(
    monthInfo: MonthInfo,
    onBackClick: () -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<EditBudget> {
        EditBudgetRoute(
            monthInfo = monthInfo,
            onBackClick = onBackClick,
            onShowSnackbar = onShowSnackbar,
        )
    }
}
