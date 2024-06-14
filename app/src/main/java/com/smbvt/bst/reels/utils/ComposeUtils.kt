package com.smbvt.bst.reels.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity

object ComposeUtils {
    @Composable
    fun getScreenWidth(): Int {
        val configuration = LocalConfiguration.current
        val density = LocalDensity.current.density
        return (configuration.screenWidthDp * density).toInt()
    }

}