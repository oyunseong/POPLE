package com.verywords.app.feature.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HtmlViewer(
    modifier: Modifier = Modifier,
    html: String,
    isVisible: Boolean = false,
    onClickFloating: () -> Unit,
    onChange: () -> Unit,
) {
    Box(modifier = modifier.fillMaxSize()) {
        if (isVisible) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = html)
            }
        }

        Column(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomEnd),
        ) {
            FloatingActionButton(
                modifier = Modifier,
                onClick = { onChange.invoke() }) {
                Text(text = "Change HTML")
            }
            FloatingActionButton(
                modifier = Modifier,
                onClick = { onClickFloating.invoke() }) {
                Text(text = "Show Html")
            }
        }

    }
}