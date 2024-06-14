package com.smbvt.bst.reels.ui.theme.fonts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.smbvt.bst.reels.ui.theme.FontSize24


@Composable
fun TextTitleWhite(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = FontSize24, color = Color.White),
    )
}