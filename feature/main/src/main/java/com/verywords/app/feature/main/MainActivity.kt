package com.verywords.app.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.verywords.app.core.designsystem.theme.POPLETheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.decorView.apply {
//            systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }
//        val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle(false, this)



        setContent {
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

