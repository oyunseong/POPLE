package com.verywords.app.feature.webview.navigation

import android.webkit.JavascriptInterface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class WebViewViewModel : ViewModel() {

    inner class WebAppInterface() {
        @JavascriptInterface
        fun finishSurvey(
            value: String
        ) {
            viewModelScope.launch {
                when (value) {
                    "onBoarding" -> {
                    }

                    else -> {
//                        showTemporalErrorToast()
                    }
                }
            }
        }


        private var lastClickTime: Long = 0
        private val doubleClickInterval: Long = 500

        @JavascriptInterface
        fun stopSurvey() {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime > doubleClickInterval) {
                lastClickTime = currentTime
                viewModelScope.launch {
//                    if (devMode) showToast("[DevMode] stopSurvey")
//                    webViewFinishedEvent.emit(Unit)
                }
            }
        }
    }
}