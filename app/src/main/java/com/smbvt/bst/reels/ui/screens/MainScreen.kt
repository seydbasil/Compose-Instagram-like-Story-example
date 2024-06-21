package com.smbvt.bst.reels.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.smbvt.bst.reels.R
import com.smbvt.bst.reels.ui.composables.PaddedContentBox
import com.smbvt.bst.reels.ui.theme.Red
import com.smbvt.bst.reels.ui.theme.Yellow
import com.smbvt.bst.reels.ui.theme.buttons.AnimatedTextButton

@Composable
fun MainScreen(onClickViewReels: () -> Unit = {}) {
    PaddedContentBox(modifier = Modifier.fillMaxSize()) {
        AnimatedTextButton(modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.view_stories),
            colors = listOf(
                Yellow, Red, Color.Green
            ),
            onClick = { onClickViewReels() })
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}