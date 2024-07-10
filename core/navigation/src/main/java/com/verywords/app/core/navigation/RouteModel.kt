package com.verywords.app.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Contributor : Route

    @Serializable
    data object Session : Route

    @Serializable
    data class SessionDetail(val sessionId: String) : Route

    @Serializable
    data class WebView(val url: String) : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Setting : MainTabRoute

    @Serializable
    data object WebView : MainTabRoute

    @Serializable
    data object  Map : MainTabRoute
}

sealed interface WebViewRoute : Route {
    @Serializable
    data object Main : WebViewRoute
}


