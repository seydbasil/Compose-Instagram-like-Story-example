package com.smbvt.bst.reels.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import com.smbvt.bst.reels.R
import com.smbvt.bst.reels.models.ReelsModel
import com.smbvt.bst.reels.ui.composables.LinearIndicator
import com.smbvt.bst.reels.ui.theme.PaddingDefault24
import com.smbvt.bst.reels.utils.Utils
import kotlinx.coroutines.launch

@Composable
fun ReelsScreen(
    onClickClose: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.bg_explainer),
//            contentDescription = "splashbg",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop,
//            alignment = Alignment.Center
//        )

        Stories(
            Utils.getContent(), onClickClose = onClickClose
        )
    }
}

@Preview
@Composable
fun PreviewReelsScreen() {
    ReelsScreen()
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Stories(listOfImage: List<ReelsModel>, onClickClose: () -> Unit) {
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
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = PaddingDefault24)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = PaddingDefault24),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
//            Spacer(modifier = Modifier.padding(4.dp))

                for (index in listOfImage.indices) {
                    LinearIndicator(
                        modifier = Modifier.weight(1f), startProgress = index == currentPage,
                        isPaused = isPaused,
                        currentPage,
                        index
                    ) {
                        if (index == listOfImage.size - 1) {
                            onClickClose()
                        } else {
                            moveToNext()
                        }
                    }

                    if (index < listOfImage.size - 1) {
                        Spacer(modifier = Modifier.padding(4.dp))
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
            ) {

                var pagePosition by remember {
                    mutableIntStateOf(0)
                }

                StoryPage(modifier = Modifier.fillMaxSize(),
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
            }
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