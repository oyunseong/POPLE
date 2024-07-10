package com.verywords.app.feature.webview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebViewRoute(
    paddingValues: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    viewModel: WebViewViewModel = viewModel()
) {
    WebViewScreen(
        url = "http://192.168.1.194:3000/MobileTest",
        javascriptInterface = viewModel.WebAppInterface(),
    )
}

@Composable
fun WebViewScreen(
    url: String,
    javascriptInterface: WebViewViewModel.WebAppInterface,
) {
    val currentUrl by remember { mutableStateOf(url) }
    val state = rememberWebViewState(currentUrl)

    WebView(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .statusBarsPadding()
            .consumeWindowInsets(
                WindowInsets.navigationBars.only(WindowInsetsSides.Vertical)
            )
            .imePadding(),
        onCreated = { webView ->
            with(webView) {
                settings.run {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                }
                addJavascriptInterface(javascriptInterface, "Android")
            }
        },
        state = state,
    )
}