package com.verywords.app.feature.map

import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verywords.app.feature.map.model.MapUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor() : ViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        Log.e("++##", "coroutineExceptionHandler : $throwable")
    }

    private val baseUrl = "https://www.naver.com"

    //    val baseUrl = "http://192.168.1.194:3000/PWUserAppMap"
//    val baseUrl = "http://192.168.1.194:3000/MobileTest"
    private val _uiState: MutableStateFlow<MapUiState> =
        MutableStateFlow(
            MapUiState(
                currentUrl = baseUrl,
                isVisibleHtmlViewer = false
            )
        )
    val uiState = _uiState.asStateFlow()

    private val _currentPageHtml: MutableStateFlow<String> = MutableStateFlow("")
    val currentPageHtml = _currentPageHtml.asStateFlow()

    init {
        viewModelScope.launch {
            currentPageHtml.collect {
//                Log.d("++##", "currentPageHtml : $it")
            }
        }
    }

    fun toggleHtmlViewer() {
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    isVisibleHtmlViewer = !uiState.value.isVisibleHtmlViewer
                )
            )
        }
    }

    inner class MapJavascriptInterface {
        @JavascriptInterface
        fun getHtml(html: String) {
            viewModelScope.launch(coroutineExceptionHandler) {
                _currentPageHtml.emit(html)
            }
        }
    }

    /**
     * html 문자열을 받아서 특정 텍스트를 변경한다.
     */
    fun updateHtml(
        html: String,
        webView: WebView
    ) {
        val doc = Jsoup.parse(html)
        val spanElement = doc.selectFirst("span.shs_text:contains(뉴스판)")
        spanElement?.text("변경된 텍스트")
        webView.loadDataWithBaseURL(baseUrl, doc.html(), "text/html", "UTF-8", null)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("++##", "MapViewModel onCleared() ${this@MapViewModel}")
    }
}