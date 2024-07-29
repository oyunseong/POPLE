package com.verywords.app.feature.main.compose

import androidx.compose.runtime.Composable
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.core.navigation.Route
import com.verywords.app.feature.main.R

internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: Int,
    val route: MainTabRoute,
) {
    HOME(
        iconResId = R.drawable.ic_scooter,
        contentDescription = R.string.TAB_MY_RIDE,
        route = MainTabRoute.Home
    ),
    SETTING(
        iconResId = R.drawable.ic_battery,
        contentDescription = R.string.TAB_BATTERY,
        route = MainTabRoute.Setting,
    ),
    MAP(
        iconResId = R.drawable.ic_map,
        contentDescription = R.string.TAB_MAP,
        route = MainTabRoute.Map,
    ),
    SUPPORT(
        iconResId = R.drawable.ic_support,
        contentDescription = R.string.TAB_SUPPORT,
        route = MainTabRoute.WebView,
    ),
    WEB_VIEW(
        iconResId = R.drawable.ic_menu,
        contentDescription = R.string.TAB_MORE,
        route = MainTabRoute.WebView,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
