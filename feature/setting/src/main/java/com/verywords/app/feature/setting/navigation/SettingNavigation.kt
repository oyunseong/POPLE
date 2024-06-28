package com.verywords.app.feature.setting.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.verywords.app.core.navigation.MainTabRoute
import com.verywords.app.feature.setting.SettingScreen

fun NavController.navigateSetting(navOptions: NavOptions) {
    navigate(MainTabRoute.Setting, navOptions)
}

fun NavGraphBuilder.settingNavGraph(
    padding: PaddingValues,
    onChangeDarkTheme: (Boolean) -> Unit
) {
    composable<MainTabRoute.Setting> {
        SettingScreen(padding)
    }
}
