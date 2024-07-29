package com.verywords.app.feature.webview

import androidx.lifecycle.ViewModel
import com.verywords.app.feature.webview.component.WebTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class WebViewContainerViewModel @Inject constructor() : ViewModel() {

    private val _currentTab: MutableStateFlow<WebTab> = MutableStateFlow(WebTab.HOME)
    val currentTab: MutableStateFlow<WebTab> = _currentTab

    val localUrl: List<String> = listOf(
        "https://www.daum.net",
        "https://www.naver.com",
        "http://192.168.0.18:3000/PWUserAppMap",
        "https://www.google.com",
        "https://github.com/oyunseong"
    )

    fun navigate(tab: WebTab) {
        _currentTab.update {
            tab
        }
    }
}