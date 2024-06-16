package com.smbvt.bst.reels.ui.theme.fonts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.smbvt.bst.reels.ui.theme.Yellow

@Composable
fun CustomText(text: String) {
    Text(modifier = Modifier, text = text, style = TextStyle(color = Yellow))
}