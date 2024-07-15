package com.verywords.app.feature.main.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.web.rememberSaveableWebViewState
import com.google.accompanist.web.rememberWebViewNavigator
import com.verywords.app.feature.home.navigation.homeNavGraph
import com.verywords.app.feature.main.MainNavigator
import com.verywords.app.feature.main.MainTab
import com.verywords.app.feature.map.navigation.mapNavGraph
import com.verywords.app.feature.setting.navigation.settingNavGraph
import com.verywords.app.feature.webview.navigation.webViewNavGraph

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    onChangeDarkTheme: (Boolean) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceDim)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            homeNavGraph(
                padding = padding,
                onShowErrorSnackBar = onShowErrorSnackBar
            )
            settingNavGraph(
                padding = padding,
                onChangeDarkTheme = onChangeDarkTheme
            )
            mapNavGraph(
                padding = padding,
                onShowErrorSnackBar = onShowErrorSnackBar
            )
            webViewNavGraph(
                padding = padding,
                onShowErrorSnackBar = onShowErrorSnackBar
            )
        }
    }
}

