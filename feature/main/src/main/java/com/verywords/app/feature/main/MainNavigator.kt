package com.verywords.app.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.feature.home.navigation.navigateHome
import com.verywords.app.feature.setting.navigation.navigateSetting
import com.verywords.app.feature.webview.navigation.navigateWebView


internal class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTab.HOME.route


    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.route == tab.javaClass.name
//            currentDestination?.hasRoute(tab::class) == true
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.SETTING -> navController.navigateSetting(navOptions)
            MainTab.HOME -> navController.navigateHome(navOptions)
            MainTab.WEB_VIEW -> navController.navigateWebView(navOptions)
        }
    }

//    fun navigateContributor() {
//        navController.navigateContributor()
//    }
//
//    fun navigateSession() {
//        navController.navigateSession()
//    }
//
//    fun navigateSessionDetail(sessionId: String) {
//        navController.navigateSessionDetail(sessionId)
//    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    fun popBackStackIfNotHome() {
//        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
//            popBackStack()
//        }
        if (navController.currentDestination?.route != MainTabRoute.Home.javaClass.name) {
            popBackStack()
        }
//    }

//    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean {
//        return navController.currentDestination?.hasRoute<T>() == true
////        return navController.currentDestination?.hasRoute<T>() == true
//    }

    }

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        true
//        currentDestination?.hasRoute(it::class) == true
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}