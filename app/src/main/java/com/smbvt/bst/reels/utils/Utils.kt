package com.smbvt.bst.reels.utils

import com.smbvt.bst.reels.R
import com.smbvt.bst.reels.models.ReelsModel

object Utils {
    fun getContent(): List<ReelsModel> {
        return listOf<ReelsModel>(
            ReelsModel(image = R.drawable.1),
            ReelsModel(image = R.drawable.2),
            ReelsModel(image = R.drawable.3),
            ReelsModel(image = R.drawable.4)
        )
    }
}