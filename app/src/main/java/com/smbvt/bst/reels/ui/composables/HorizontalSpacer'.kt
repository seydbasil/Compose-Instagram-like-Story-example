package com.smbvt.bst.reels.ui.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun HorizontalSpacer(modifier: Modifier = Modifier, value: Dp) {
    Spacer(modifier = modifier.width(value))
}