package com.verywords.app.feature.webview.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    LaunchedEffect(Unit) {
        Log.d("++##", "WebViewRoute")
    }

    WebViewScreen(
        url = "http://192.168.0.18:3000",
        javascriptInterface = viewModel.WebAppInterface(),
    )
}

@Composable
fun WebViewScreen(
    url: String,
    javascriptInterface: WebViewViewModel.WebAppInterface,
) {
    var currentUrl by remember { mutableStateOf(url) }
    val state = rememberWebViewState(currentUrl)

    LaunchedEffect(Unit) {
        Log.d("++##", "WebViewScreen")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "WebViewScreen")
    }

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