package dev.atick.compose.navigation.analysis

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import dev.atick.compose.ui.analysis.AnalysisRoute
import dev.atick.core.utils.MonthInfo
import kotlinx.serialization.Serializable

/**
 * Represents the analysis route.
 */
@Serializable
data object Analysis

/**
 * Navigates to the analysis screen.
 *
 * @param navOptions The navigation options.
 */
fun NavController.navigateToAnalysis(navOptions: NavOptions?) {
    navigate(Analysis, navOptions)
}

/**
 * Builds the analysis screen.
 *
 * @param monthInfo The month information.
 * @param onShowSnackbar The callback to show a snackbar.
 */
fun NavGraphBuilder.analysisScreen(
    monthInfo: MonthInfo,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<Analysis> {
        AnalysisRoute(
            monthInfo = monthInfo,
            onShowSnackbar = onShowSnackbar,
        )
    }
}
