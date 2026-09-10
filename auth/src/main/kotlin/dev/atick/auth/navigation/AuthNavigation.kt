package dev.atick.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.atick.auth.ui.signin.SignInRoute
import dev.atick.auth.ui.signup.SignUpRoute
import kotlinx.serialization.Serializable

@Serializable
data object AuthNavGraph

@Serializable
data object SignIn

@Serializable
data object SignUp

fun NavController.navigateToAuthNavGraph(navOptions: NavOptions? = null) {
    navigate(AuthNavGraph, navOptions)
}

fun NavController.navigateToSignInRoute(navOptions: NavOptions? = null) {
    navigate(SignIn, navOptions)
}

fun NavController.navigateToSignUpRoute(navOptions: NavOptions? = null) {
    navigate(SignUp, navOptions)
}

fun NavGraphBuilder.signInScreen(
    onSignUpClick: () -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<SignIn> {
        SignInRoute(
            onSignUpClick = onSignUpClick,
            onShowSnackbar = onShowSnackbar,
        )
    }
}

fun NavGraphBuilder.signUpScreen(
    onSignInClick: () -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable<SignUp> {
        SignUpRoute(
            onSignInClick = onSignInClick,
            onShowSnackbar = onShowSnackbar,
        )
    }
}

fun NavGraphBuilder.authNavGraph(
    nestedNavGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation<AuthNavGraph>(startDestination = SignIn) {
        nestedNavGraphs()
    }
}
