package com.smbvt.bst.reels.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.smbvt.bst.reels.ui.screens.StoryScreen
import com.smbvt.bst.reels.ui.theme.AlphaWhite6BFFFFFF

@Composable
fun StoryTracker(
    modifier: Modifier = Modifier,
    isPaused: Boolean = false,
    currentPage: Int = 0,
    onClickClose: () -> Unit = {},
    moveToNext: () -> Unit = {},
    pageCount: Int = 1,
    trackBackgroundColor: Color = AlphaWhite6BFFFFFF,
    activeTrackBackgroundColor: Color = Color.White,
    delayInMillis: Long = 5000,
    indicatorHorizontalPadding : Dp = 2.dp,
    indicatorCornerRadius : Dp = 12.dp,
    indicatorHeight : Dp = 2.dp
) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (index in 0 until pageCount) {
            LinearIndicator(
                modifier = Modifier.weight(1f),
                startProgress = index == currentPage,
                isPaused = isPaused,
                currentPage,
                index,
                onPageHoldEnd = {
                    if (index == pageCount - 1) {
                        onClickClose()
                    } else {
                        moveToNext()
                    }
                },
                trackBackgroundColor = trackBackgroundColor,
                activeTrackBackgroundColor = activeTrackBackgroundColor,
                delayInMillis = delayInMillis,
                indicatorCornerRadius = indicatorCornerRadius,
                indicatorHeight = indicatorHeight
            )

            if (index < pageCount - 1) {
                Spacer(modifier = Modifier.padding(indicatorHorizontalPadding))
            }
        }
    }
}


@Preview
@Composable
fun PreviewStoryTracker() {
    StoryScreen()
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewStoryTrackerNight() {
    StoryScreen()
}