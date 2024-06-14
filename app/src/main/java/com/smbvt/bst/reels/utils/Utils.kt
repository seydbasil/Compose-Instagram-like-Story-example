package com.smbvt.bst.reels.utils

import com.smbvt.bst.reels.R
import com.smbvt.bst.reels.models.ReelsModel

object Utils {
    fun getContent(): List<ReelsModel> {
        return listOf<ReelsModel>(
            ReelsModel(image = R.drawable.blue_lake, "Blue lake"),
            ReelsModel(image = R.drawable.green_grass, text = "Green grass"),
            ReelsModel(image = R.drawable.forest_and_river, "Forest and river"),
            ReelsModel(image = R.drawable.green_mountains, "Green mountains")
        )
    }
}