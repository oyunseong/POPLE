package com.verywords.app.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.feature.home.HomeRoute


fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Home,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    onSessionClick: () -> Unit = {},
    onContributorClick: () -> Unit = {},
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    composable<MainTabRoute.Home> {
        HomeRoute(padding, onSessionClick, onContributorClick, onShowErrorSnackBar)
    }
}
