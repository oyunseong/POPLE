package com.verywords.app.feature.main

import androidx.compose.runtime.Composable
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.core.navigation.Route

internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: String,
    val route: MainTabRoute,
) {
    HOME(
        iconResId = R.drawable.ic_android_black_24dp,
        contentDescription = "홈",
        route = MainTabRoute.Home
    ),
    SETTING(
        iconResId = R.drawable.ic_android_black_24dp,
        contentDescription = "설정",
        route = MainTabRoute.Setting,
    );

//    BOOKMARK(
//        iconResId = R.drawable.ic_android_black_24dp,
//        contentDescription = "북마크",
//        MainTabRoute.Bookmark,
//    );

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
