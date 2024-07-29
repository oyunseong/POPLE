package com.verywords.app.feature.main

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.verywords.app.core.designsystem.theme.POPLETheme
import com.verywords.app.feature.home.HomeFragment
import com.verywords.app.feature.login.LoginFragment
import com.verywords.app.feature.main.compose.MainNavigator
import com.verywords.app.feature.main.compose.MainScreen
import com.verywords.app.feature.main.compose.rememberMainNavigator
import com.verywords.app.feature.main.databinding.ActivityMainBinding
import com.verywords.app.feature.map.MapFragment
import com.verywords.app.feature.webview.WebViewContainer
import com.verywords.app.feature.webview.WebViewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.decorView.apply {
//            systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }
//        val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle(false, this)
        val isWebViewMode = true
        setContent {
            val snackBarHostState = remember { SnackbarHostState() }
            if (isWebViewMode) {
                POPLETheme {
                    WebViewContainer(snackBarHostState=snackBarHostState)
                }
            } else {
                val navigator: MainNavigator = rememberMainNavigator()
                POPLETheme {
                    MainScreen(
                        navigator = navigator,
                        onChangeDarkTheme = { isDarkTheme -> false }
                    )
                }
            }
        }
    }
}





