package dev.atick.compose.navigation.expenses

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.atick.compose.ui.expenses.EditExpenseRoute
import kotlinx.serialization.Serializable

/**
 * Represents the edit expense route.
 */
@Serializable
data class EditExpense(val expenseId: Long)

/**
 * Navigates to the edit expense screen.
 *
 * @param expenseId The expense ID.
 */
fun NavController.navigateToEditExpenseScreen(expenseId: Long) {
    navigate(EditExpense(expenseId)) { launchSingleTop = true }
}

/**
 * Builds the edit expense screen.
 *
 * @param onBackClick The callback to handle the back click.
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.editExpenseScreen(
    onBackClick: () -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<EditExpense> {
        EditExpenseRoute(
            onBackClick = onBackClick,
            onShowSnackbar = onShowSnackbar,
        )
    }
}
