package com.smbvt.bst.reels.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.smbvt.bst.reels.ui.screens.MainScreen
import com.smbvt.bst.reels.ui.screens.ReelsScreen

const val mainScreen = "mainScreen"
const val reelsScreen = "reelsScreen"

@Composable
fun ReelsNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = mainScreen) {
        composable(mainScreen) {
            MainScreen(onClickViewReels = {
                navController.navigate(reelsScreen)
            })
        }
        composable(reelsScreen) {
            ReelsScreen(onClickClose = {
                navController.popBackStack()
            })
        }
    }
}