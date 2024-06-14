package com.smbvt.bst.reels.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LineIndicatorRow(
    modifier: Modifier = Modifier,
    isPaused: Boolean,
    currentPage: Int,
    onClickClose: () -> Unit,
    moveToNext: () -> Unit,
    listOfImage: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (index in 0 until listOfImage) {
            LinearIndicator(
                modifier = Modifier.weight(1f), startProgress = index == currentPage,
                isPaused = isPaused,
                currentPage,
                index
            ) {
                if (index == listOfImage - 1) {
                    onClickClose()
                } else {
                    moveToNext()
                }
            }

            if (index < listOfImage - 1) {
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}