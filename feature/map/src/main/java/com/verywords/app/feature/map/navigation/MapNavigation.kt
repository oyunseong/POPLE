package com.verywords.app.feature.map.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.google.accompanist.web.WebViewNavigator
import com.google.accompanist.web.WebViewState
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.feature.map.MapRoute

fun NavController.navigateMap(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.Map,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.mapNavGraph(
    webViewState: WebViewState,
    navigator: WebViewNavigator,
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    composable<MainTabRoute.Map> {
        MapRoute(
//            webViewState,
//            navigator,
//            padding,
//            onShowErrorSnackBar
        )
    }
}

