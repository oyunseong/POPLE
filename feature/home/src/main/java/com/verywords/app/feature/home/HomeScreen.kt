package com.verywords.app.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onSessionClick: () -> Unit,
    onContributorClick: () -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
//    viewModel: HomeViewModel = hiltViewModel(),
) {
//    val sponsorsUiState by viewModel.sponsorsUiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
//        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackBar(throwable) }
    }

//    HomeScreen(
//        padding = padding,
//        sponsorsUiState = sponsorsUiState,
//        onSessionClick = onSessionClick,
//        onContributorClick = onContributorClick,
//    )
    HomeScreen(
        padding = padding
    )
}


@Composable
fun HomeScreen(
    padding: PaddingValues,
) {
    Box(
        modifier = Modifier
            .padding(padding)
            .background(color = Color.Yellow)
    ) {
        Text(text = "is home")
    }
}