package com.smbvt.bst.reels.ui.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smbvt.bst.reels.ui.theme.AlphaWhite6BFFFFFF
import kotlinx.coroutines.delay


/**
 *  @param delayInMillis can be used to hold the page for a specific time
 *  @param isPaused can be used to pause the page for a while, for ex : when a user click on the story page, just pass isPaused true, then the page do not change automatically
 */
@Composable
fun LinearIndicator(
    modifier: Modifier,
    startProgress: Boolean = false,
    isPaused: Boolean,
    currentPage: Int,
    index: Int,
    onPageHoldEnd: () -> Unit,
    trackBackgroundColor: Color = AlphaWhite6BFFFFFF,
    activeTrackBackgroundColor: Color = Color.White,
    delayInMillis : Long = 5000
) {
    var progress by remember {
        mutableFloatStateOf(0.00f)
    }

    if (startProgress) {
        LaunchedEffect(key1 = isPaused, block = {
            while (progress < 1f) {
                if((currentPage == index) && !isPaused) {
                    progress += 0.01f
                }
                delay(delayInMillis / 100) // 5 sec -> 5000/100 -> 50
            }

            onPageHoldEnd()
        })
    } else {
        progress = 0.00f
    }


    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = ""
    )
    LinearProgressIndicator(
        trackColor = trackBackgroundColor,

        modifier = modifier
            .padding(top = 12.dp, bottom = 12.dp)
            .clip(
                RoundedCornerShape(12.dp)
            ), color = activeTrackBackgroundColor, progress = animatedProgress
    )
}