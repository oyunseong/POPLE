package com.verywords.app.feature.webview

import android.annotation.SuppressLint
import android.os.Build
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.isVisible

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SetJavaScriptEnabled")
@Composable
internal fun AndroidWebViewScreen(
    url: String,
    isShown: Boolean = false,
    chromeClient: WebChromeClient = remember { object : WebChromeClient() {} },
    client: WebViewClient = remember { object : WebViewClient() {} },
) {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = {
            FrameLayout(context).apply {
                val webView = WebView(context).apply {
                    this.layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    settings.run {
                        javaScriptEnabled = true
                        defaultTextEncodingName = "UTF-8"
                        cacheMode = WebSettings.LOAD_DEFAULT
                        setSupportMultipleWindows(true)
                    }
                    webChromeClient = chromeClient
                    webViewClient = client
                    loadUrl(url)
                }
                addView(webView)
            }
        },
        update = { parentLayout ->
            parentLayout.isVisible = isShown
        },
    )
}
