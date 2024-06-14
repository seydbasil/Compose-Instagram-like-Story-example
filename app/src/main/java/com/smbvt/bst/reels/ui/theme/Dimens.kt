package com.smbvt.bst.reels.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PaddingDefault10 = 10.dp
val PaddingDefault24 = 24.dp
val PaddingDefault100 = 100.dp



val a : Dp
@Composable
get() = if(isSystemInDarkTheme()) 10.dp else 11.dp


val RoundedCorner16 = 16.dp
val RoundedCorner14 = 14.dp
val RoundedCorner12 = 12.dp
val RoundedCorner8 = 8.dp
val RoundedCorner4 = 4.dp
val BorderWidth1 = 1.dp
val ElevationWidth5 = 5.dp

val QRScannerWidth = 345.dp
val QRScannerHeight= 377.dp