package com.verywords.app.feature.map

import android.util.Log
import android.webkit.JavascriptInterface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Instant
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor() : ViewModel() {
    val webViewState: MutableState<WebViewState> = mutableStateOf(
        WebViewState(
            WebContent.Url(
                url = "http://192.168.1.194:3000/PWUserAppMap",
                additionalHttpHeaders = emptyMap()
            )
        )
    )

    init {
        Log.d("++##", "MapViewModel init() ${this@MapViewModel}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("++##", "MapViewModel onCleared() ${this@MapViewModel}")
    }

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
//            val currentTime = System.currentTimeMillis()
//            if (currentTime - lastClickTime > doubleClickInterval) {
//                lastClickTime = currentTime
//                viewModelScope.launch {
////                    if (devMode) showToast("[DevMode] stopSurvey")
////                    webViewFinishedEvent.emit(Unit)
//                }
//            }
        }
    }
}