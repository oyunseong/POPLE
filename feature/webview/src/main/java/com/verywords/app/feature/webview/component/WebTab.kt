package com.verywords.app.feature.webview.component

import androidx.compose.runtime.Composable
import com.verywords.app.core.navigation.Route
import com.verywords.app.core.navigation.WebViewRoute
import com.verywords.app.feature.webview.R

enum class WebTab(
    val iconResId: Int,
    internal val contentDescription: Int,
    val route: WebViewRoute,
) {
    HOME(
        iconResId = R.drawable.ic_scooter,
        contentDescription = R.string.TAB_MY_RIDE,
        route = WebViewRoute.Home
    ),
    BATTERY(
        iconResId = R.drawable.ic_battery,
        contentDescription = R.string.TAB_BATTERY,
        route = WebViewRoute.Battery,
    ),
    MAP(
        iconResId = R.drawable.ic_map,
        contentDescription = R.string.TAB_MAP,
        route = WebViewRoute.Map,
    ),
    SUPPORT(
        iconResId = R.drawable.ic_support,
        contentDescription = R.string.TAB_SUPPORT,
        route = WebViewRoute.Support,
    ),
    MORE(
        iconResId = R.drawable.ic_menu,
        contentDescription = R.string.TAB_MORE,
        route = WebViewRoute.More,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (WebViewRoute) -> Boolean): WebTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
