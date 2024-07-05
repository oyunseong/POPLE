package com.verywords.app.feature.webview.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.core.navigation.WebViewRoute

fun NavController.navigateWebView(navOptions: NavOptions) {
    navigate(
        route = MainTabRoute.WebView,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.webViewNavGraph(
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    composable<MainTabRoute.WebView> {
        WebViewRoute(padding, onShowErrorSnackBar)
    }
}

