package com.smbvt.bst.reels.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.smbvt.bst.reels.models.ReelsModel
import com.smbvt.bst.reels.ui.theme.PaddingDefault100
import com.smbvt.bst.reels.ui.theme.fonts.TextTitleWhite

@Composable
fun StoryPageContent(modifier: Modifier = Modifier, item: ReelsModel) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        TextTitleWhite(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = PaddingDefault100),
            text = item.text
        )
    }
}