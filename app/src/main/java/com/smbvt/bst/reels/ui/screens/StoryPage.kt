package com.smbvt.bst.reels.ui.screens

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import com.smbvt.bst.reels.models.ReelsModel
import com.smbvt.bst.reels.ui.theme.PaddingDefault100
import com.smbvt.bst.reels.ui.theme.PaddingDefault24
import com.smbvt.bst.reels.ui.theme.fonts.TextTitleWhite
import com.smbvt.bst.reels.utils.ComposeUtils.getScreenWidth

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun StoryPage(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    listOfImage: List<ReelsModel>,
    onClickLeft: () -> Unit = {},
    onCLickRight: () -> Unit = {},
    onPause: () -> Unit = {},
    onResume: () -> Unit = {},
    onChangePage: (Int) -> Unit
) {

    LaunchedEffect(pagerState.currentPage) {
        onChangePage(pagerState.currentPage)
    }

    val screenWidth = getScreenWidth()
    var initialTime by remember {
        mutableLongStateOf(0)
    }
    HorizontalPager(userScrollEnabled = false, state = pagerState, modifier = modifier./*pointerInput(Unit) {
            detectTapGestures { offset ->
                Timber.e("offset : ${offset.x}, screenWidth : $screenWidth")
                val halfWidth = screenWidth / 2
                if (offset.x > halfWidth) {
                    onCLickRight()
                } else {
                    onClickLeft()
                }
            }
        }.*/pointerInteropFilter {
        when (it.action) {
            MotionEvent.ACTION_DOWN -> {
                initialTime = System.currentTimeMillis()
                onPause()
                // pause here
            }

            MotionEvent.ACTION_MOVE -> {
            }

            MotionEvent.ACTION_UP -> {
                val currentTime = System.currentTimeMillis()
                val threshold = currentTime - initialTime
                onResume()
                if (threshold > 300L) {
                    // resume
                } else {
                    val halfWidth = screenWidth / 2
                    if (it.x > halfWidth) {
                        onCLickRight()
                    } else {
                        onClickLeft()
                    }
                }
            }

            else -> {
                Log.e("Reels screen ", "pointerInteropFilter : ${it.action}")
            }
        }
        true
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = listOfImage[it].image),
                contentDescription = null
            )
            TextTitleWhite(
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = PaddingDefault100), text = listOfImage[it].text
            )
        }
    }
}
