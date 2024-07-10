package com.verywords.app.feature.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.verywords.app.core.designsystem.theme.POPLETheme

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onSessionClick: () -> Unit,
    onContributorClick: () -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
//    val sponsorsUiState by viewModel.sponsorsUiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
//        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackBar(throwable) }
    }

    val cnt by viewModel.cnt.collectAsState()
    HomeScreen(
        padding = padding,
        cnt = cnt,
        onClick1 = {
            viewModel.plusCnt()
        }
    )
}


@Composable
fun HomeScreen(
    padding: PaddingValues,
    cnt: Int,
    onClick1: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(padding)
            .background(color = Color.Yellow)
            .fillMaxSize()
    ) {
        LaunchedEffect(Unit) {
            Log.d("++##", "HomeScreen LaunchedEffect")

        }
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { onClick1.invoke() }) {
            Text(
                text = "click",
                style = POPLETheme.typography.headingL
            )
        }

        Column {
            Box(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                ProvideTextStyle(value = POPLETheme.typography.headingL) {
                    Text(
                        text = "$cnt home",
                        style = POPLETheme.typography.headingL
                    )
                }
            }

            Box(modifier = Modifier) {
                Text(text = " home")
            }
        }


    }
}