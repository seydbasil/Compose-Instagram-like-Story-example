package com.smbvt.bst.reels.ui.theme.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.smbvt.bst.reels.ui.theme.Gray
import com.smbvt.bst.reels.ui.theme.GrayDark
import com.smbvt.bst.reels.ui.theme.texts.AnimatedText

@Composable
fun AnimatedTextButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier.background(color = if (isSystemInDarkTheme()) Gray else GrayDark),
        onClick = onClick
    ) {
        AnimatedText(text = text)
    }
}