package com.smbvt.bst.reels.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smbvt.bst.reels.ui.screens.MainScreen
import com.smbvt.bst.reels.ui.screens.StoryScreen

const val mainScreen = "mainScreen"
const val storyScreen = "storyScreen"

@Composable
fun StoryNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = mainScreen) {
        composable(mainScreen) {
            MainScreen(onClickViewReels = {
                navController.navigate(storyScreen)
            })
        }
        composable(storyScreen) {
            StoryScreen(onClickClose = {
                navController.navigateUp()
            })
        }
    }
}