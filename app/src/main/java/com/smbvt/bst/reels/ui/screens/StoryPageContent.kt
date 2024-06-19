package com.smbvt.bst.reels.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.smbvt.bst.reels.models.ReelsModel
import com.smbvt.bst.reels.ui.theme.AlphaBlack30000000
import com.smbvt.bst.reels.ui.theme.AlphaWhite30FFFFFF
import com.smbvt.bst.reels.ui.theme.PaddingDefault10
import com.smbvt.bst.reels.ui.theme.PaddingDefault100
import com.smbvt.bst.reels.ui.theme.texts.TextTitleBlack

@Composable
fun StoryPageContent(modifier: Modifier = Modifier, item: ReelsModel) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = PaddingDefault100)
                .background(color = if (isSystemInDarkTheme()) AlphaBlack30000000 else AlphaWhite30FFFFFF)
                .padding(PaddingDefault10)
        ) {
            TextTitleBlack(
                modifier = Modifier.align(Alignment.Center), text = item.text
            )
        }
    }
}