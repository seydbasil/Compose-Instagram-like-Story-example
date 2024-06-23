package com.smbvt.bst.reels.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.smbvt.bst.reels.R
import com.smbvt.bst.reels.ui.composables.PaddedContentBox
import com.smbvt.bst.reels.ui.composables.StoryTracker
import com.smbvt.bst.reels.ui.theme.GradientBlackTransparent
import com.smbvt.bst.reels.ui.theme.PaddingDefault12
import com.smbvt.bst.reels.ui.theme.PaddingDefault36
import com.smbvt.bst.reels.ui.theme.PaddingDefault4
import com.smbvt.bst.reels.utils.Utils
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryScreen(
    modifier: Modifier = Modifier,
    onClickClose: () -> Unit = {},
) {

    val listOfImage = Utils.getContent()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { listOfImage.size })
    val coroutineScope = rememberCoroutineScope()

    var currentPage by remember {
        mutableIntStateOf(0)
    }

    var isPaused by remember {
        mutableStateOf(false)
    }

    fun moveToNext() {
        coroutineScope.launch { pagerState.animateScrollToPage(currentPage) }

        if (currentPage < listOfImage.size - 1) {
            currentPage++
        }
    }

    fun moveToPrevious() {
        coroutineScope.launch { pagerState.animateScrollToPage(currentPage) }

        if (currentPage > 0) {
            currentPage--
        }
    }

    PaddedContentBox(
        modifier = modifier.fillMaxSize()
    ) {
        // Here we can add common background for all stories

//        Image(
//            painter = painterResource(id = R.drawable.bg_story),
//            contentDescription = "splashbg",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop,
//            alignment = Alignment.Center
//        )

        var pagePosition by remember {
            mutableIntStateOf(0)
        }
        StoryPager(modifier = Modifier.fillMaxSize(),
            pagerState = pagerState,
            listOfImage = listOfImage,
            onClickLeft = {
                moveToPrevious()
            },
            onCLickRight = {
                moveToNext()
            },
            onPause = {
                isPaused = true
            },
            onResume = {
                isPaused = false
            },
            onChangePage = { pagePosition = it })

        Box(modifier = Modifier.background(brush = GradientBlackTransparent)) {
            StoryTracker(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(
                        start = PaddingDefault4, end = PaddingDefault4, bottom = PaddingDefault36
                    ),
                isPaused = isPaused,
                currentPage = currentPage,
                onClickClose = onClickClose,
                moveToNext = {
                    moveToNext()
                },
                pageCount = listOfImage.size
            )
        }

        Image(painter = painterResource(id = R.drawable.ic_close_reels),
            contentDescription = null,
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false),
                ) {
                    onClickClose()
                }
                .padding(PaddingDefault12)
                .align(Alignment.TopStart))
    }
}

@Preview
@Composable
fun PreviewStoryScreen() {
    StoryScreen()
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewStoryScreenNight() {
    StoryScreen()
}