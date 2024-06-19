package com.smbvt.bst.reels.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smbvt.bst.reels.ui.theme.AlphaWhite6BFFFFFF

@Composable
fun StoryTracker(
    modifier: Modifier = Modifier,
    isPaused: Boolean,
    currentPage: Int,
    onClickClose: () -> Unit,
    moveToNext: () -> Unit,
    listOfImage: Int,
    trackBackgroundColor: Color = AlphaWhite6BFFFFFF,
    activeTrackBackgroundColor: Color = Color.White,
    delayInMillis: Long = 5000
) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (index in 0 until listOfImage) {
            LinearIndicator(
                modifier = Modifier.weight(1f),
                startProgress = index == currentPage,
                isPaused = isPaused,
                currentPage,
                index,
                onPageHoldEnd = {
                    if (index == listOfImage - 1) {
                        onClickClose()
                    } else {
                        moveToNext()
                    }
                },
                trackBackgroundColor = trackBackgroundColor,
                activeTrackBackgroundColor = activeTrackBackgroundColor,
                delayInMillis = delayInMillis,
            )

            if (index < listOfImage - 1) {
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}