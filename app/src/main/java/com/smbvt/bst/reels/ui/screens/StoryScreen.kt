package com.smbvt.bst.reels.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.rememberPagerState
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
import com.smbvt.bst.reels.ui.composables.StoryTracker
import com.smbvt.bst.reels.ui.theme.AlphaBlack30000000
import com.smbvt.bst.reels.ui.theme.PaddingDefault24
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

    Box(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
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

        Box(modifier = Modifier.background(color = AlphaBlack30000000)){
            StoryTracker(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(horizontal = PaddingDefault24),
                isPaused = isPaused,
                currentPage = currentPage,
                onClickClose = onClickClose,
                moveToNext = {
                    moveToNext()
                },
                listOfImage = listOfImage.size
            )
        }

        Image(painter = painterResource(id = R.drawable.ic_close_reels),
            contentDescription = null,
            modifier = Modifier
                .padding(PaddingDefault24)
                .align(Alignment.BottomCenter)
                .clickable {
                    onClickClose()
                })
    }
}

@Preview
@Composable
fun PreviewStoryScreen() {
    StoryScreen()
}