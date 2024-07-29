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
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Deprecated(
    message = "Use AndroidWebViewScreen instead",
    replaceWith = ReplaceWith("AndroidWebViewScreen(url, isShown, chromeClient, client)")
)
@Composable
fun WebViewRoute(
    modifier: Modifier = Modifier,
    url: String,
    isHide: Boolean = false,
    viewModel: WebViewViewModel = viewModel()
) {
    WebViewScreen(
        modifier = modifier,
        url = url,
        isHide = isHide,
        javascriptInterface = viewModel.WebAppInterface(),
    )
}

@Composable
fun WebViewScreen(
    modifier: Modifier = Modifier,
    url: String,
    isHide: Boolean = false,
    javascriptInterface: WebViewViewModel.WebAppInterface,
) {
    val currentUrl by remember { mutableStateOf(url) }
    val state = rememberWebViewState(currentUrl)

    WebView(
        modifier = modifier
            .alpha(if (isHide) 0f else 1f)
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