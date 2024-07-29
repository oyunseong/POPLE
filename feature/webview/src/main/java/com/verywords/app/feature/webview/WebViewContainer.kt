package com.verywords.app.feature.webview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.verywords.app.feature.webview.component.WebTab
import com.verywords.app.feature.webview.component.WebViewBottomBar
import kotlinx.collections.immutable.toPersistentList


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WebViewContainer(
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState,
    viewModel: WebViewContainerViewModel = hiltViewModel()
) {
    val currentTab by viewModel.currentTab.collectAsState()
    Scaffold(
        modifier = modifier,
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                AndroidWebViewScreen(
                    url = viewModel.localUrl[0],
                    isShown = currentTab == WebTab.HOME,
                )
                AndroidWebViewScreen(
                    url = viewModel.localUrl[1],
                    isShown = currentTab == WebTab.BATTERY,
                )
                AndroidWebViewScreen(
                    url = viewModel.localUrl[2],
                    isShown = currentTab == WebTab.MAP,
                )
                AndroidWebViewScreen(
                    url = viewModel.localUrl[3],
                    isShown = currentTab == WebTab.SUPPORT,
                )
                AndroidWebViewScreen(
                    url = viewModel.localUrl[4],
                    isShown = currentTab == WebTab.MORE,
                )
            }
        },
        bottomBar = {
            WebViewBottomBar(
                modifier = Modifier.navigationBarsPadding(),
                visible = true,
                tabs = WebTab.entries.toPersistentList(),
                currentTab = currentTab,
                onTabSelected = { viewModel.navigate(it) }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    )
}