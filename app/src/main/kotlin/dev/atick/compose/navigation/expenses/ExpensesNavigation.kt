package dev.atick.compose.navigation.expenses

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.atick.compose.ui.expenses.ExpensesRoute
import dev.atick.core.utils.MonthInfo
import kotlinx.serialization.Serializable

/**
 * Represents the expenses route.
 */
@Serializable
data object Expenses

/**
 * Represents the expenses navigation graph.
 */
@Serializable
data object ExpensesNavGraph

/**
 * Navigates to the expenses navigation graph.
 *
 * @param navOptions The navigation options.
 */
fun NavController.navigateToExpensesNavGraph(navOptions: NavOptions? = null) {
    navigate(ExpensesNavGraph, navOptions)
}

/**
 * Navigates to the expenses screen.
 *
 * @param monthInfo The month information.
 * @param onExpenseClick The callback to handle the expense click.
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.expensesScreen(
    monthInfo: MonthInfo,
    onExpenseClick: (Long) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<Expenses> {
        ExpensesRoute(
            monthInfo = monthInfo,
            onExpenseClick = onExpenseClick,
            onShowSnackbar = onShowSnackbar,
        )
    }
}

/**
 * Builds the expenses navigation graph.
 *
 * @param nestedNavGraphs The nested navigation graphs.
 */
fun NavGraphBuilder.expensesNavGraph(
    nestedNavGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<ExpensesNavGraph>(startDestination = Expenses) {
        nestedNavGraphs()
    }
}
