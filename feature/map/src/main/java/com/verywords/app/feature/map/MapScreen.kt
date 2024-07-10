package com.verywords.app.feature.map

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewNavigator
import com.google.accompanist.web.WebViewState
import com.google.accompanist.web.rememberSaveableWebViewState
import com.google.accompanist.web.rememberWebViewNavigator


@Composable
fun MapRoute(
//    webViewState: WebViewState,
//    navigator: WebViewNavigator,
//    paddingValues: PaddingValues,
//    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    viewModel: MapViewModel = hiltViewModel()
) {
    val webViewState = rememberSaveableWebViewState()
    val navigator = rememberWebViewNavigator()

    LaunchedEffect(navigator) {
        Log.d("++##", "webViewState : ${webViewState}")
        Log.d("++##", "navigator : ${navigator}")
        val bundle = webViewState.viewState
        if (bundle == null) {
//            navigator.loadUrl("192.168.1.194:3000/PWUserAppMap")
            navigator.loadUrl("https://www.naver.com")
        }
    }
    val webView= rememberWebView()
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { webView },
    )

//    WebView(
//        state = webViewState,
//        navigator = navigator,
//        modifier = Modifier.fillMaxSize(),
//        onCreated = { webView ->
//            with(webView) {
//                settings.run {
//                    javaScriptEnabled = true
//                    domStorageEnabled = true
//                }
//                addJavascriptInterface(viewModel.WebAppInterface(), "Android")
//            }
//        }
//    )

    LaunchedEffect(Unit) {
        Log.d("++##", "MapRoute LaunchedEffect")
    }
    DisposableEffect(Unit) {
        onDispose {
            Log.d("++##", "MapRoute is being disposed")
        }
    }
//    MapScreen(
//        state = webViewState,
//        navigator = navigator,
//        javascriptInterface = viewModel.WebAppInterface(),
//    )
}

@Composable
fun rememberWebView(): WebView {
    val context = LocalContext.current
    val webView = remember {
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl("https://www.naver.com")
        }
    }
    return webView
}

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    state: WebViewState,
    navigator: WebViewNavigator,
    javascriptInterface: MapViewModel.WebAppInterface,
) {
    WebView(
        navigator = navigator,
        modifier = modifier
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