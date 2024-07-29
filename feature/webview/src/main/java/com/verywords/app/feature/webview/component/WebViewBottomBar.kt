package com.verywords.app.feature.webview.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.verywords.app.core.designsystem.component.VerticalSpacer
import com.verywords.app.core.designsystem.theme.Gray300
import com.verywords.app.core.designsystem.theme.Gray400
import com.verywords.app.core.designsystem.theme.POPLETheme
import com.verywords.app.core.designsystem.theme.Primary500
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Composable
internal fun WebViewBottomBar(
    modifier: Modifier = Modifier,
    visible: Boolean,
    tabs: PersistentList<WebTab>,
    currentTab: WebTab?,
    onTabSelected: (WebTab) -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, it.height) }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = Color.White)
        ) {
            LinearLine(height = 1f)
            VerticalSpacer(1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 20.dp),
            ) {
                tabs.forEach { tab ->
                    WebViewBottomBarItem(
                        tab = tab,
                        selected = tab == currentTab,
                        onClick = { onTabSelected(tab) },
                    )
                }
            }
        }

    }
}

@Composable
fun LinearLine(
    width: Float = 0f,
    height: Float = 0f,
    color: Color = Gray300
) {
    Box(
        modifier = Modifier
            .then(if (width == 0f) Modifier.fillMaxWidth() else Modifier.width(width.dp))
            .then(if (height == 0f) Modifier.fillMaxHeight() else Modifier.height(height.dp))
            .background(color = color)
    )
}

@Composable
private fun RowScope.WebViewBottomBarItem(
    modifier: Modifier = Modifier,
    tab: WebTab,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                indication = null,
                role = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.padding(vertical = 5.5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(23.dp),
                painter = painterResource(tab.iconResId),
                tint = if (selected) Primary500 else Gray400,
                contentDescription = stringResource(id = tab.contentDescription),
            )
            VerticalSpacer(2.dp)
            Text(
                text = stringResource(id = tab.contentDescription),
                color = if (selected) Primary500 else Gray400,
                style = POPLETheme.typography.bodySr
            )
        }

    }
}

@Preview
@Composable
private fun WebViewBottomBarPreview() {
    POPLETheme {
        WebViewBottomBar(
            visible = true,
            tabs = WebTab.entries.toPersistentList(),
            currentTab = WebTab.HOME,
            onTabSelected = { },
        )
    }
}
