package com.verywords.app.feature.main.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.core.navigation.Route
import com.verywords.app.feature.home.navigation.navigateHome
import com.verywords.app.feature.map.navigation.navigateMap
import com.verywords.app.feature.setting.navigation.navigateSetting
import com.verywords.app.feature.webview.navigation.navigateWebView

/**
 * 2024년도 1차 배포는 React로 개발된 UI를 WebView로 보여주는 것으로 결정되어 Compose Navigation은 보류되었습니다.
 */
internal class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTab.HOME.route


    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }



    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            // 탭을 선택했을 때 백 스택에 대규모 대상 스택이 빌드되지 않도록 그래프의 시작 대상을 팝업으로 만듭니다.
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true    //
            }
            launchSingleTop = true  // 백 스택 위에 대상의 사본이 최대 1개가 되도록 해 줍니다.
            restoreState = true     // 대상이 이미 백 스택에 있으면 그 상태를 복원합니다.
        }

        when (tab) {
            MainTab.HOME -> navController.navigateHome(navOptions)
            MainTab.SETTING -> navController.navigateSetting(navOptions)
            MainTab.MAP -> navController.navigateMap(navOptions)
            MainTab.WEB_VIEW -> navController.navigateWebView(navOptions)
            MainTab.SUPPORT -> navController.navigateWebView(navOptions)
        }
    }


//
//    fun navigateSessionDetail(sessionId: String) {
//        navController.navigateSessionDetail(sessionId)
//    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
            popBackStack()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean {
        return navController.currentDestination?.hasRoute<T>() == true
    }

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}