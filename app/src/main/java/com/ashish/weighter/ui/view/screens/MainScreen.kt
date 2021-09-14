package com.ashish.weighter.ui.view.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.navigation.NavigateToScreen
import com.ashish.weighter.ui.component.BottomNavigationBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(  bottomBar = { BottomNavigationBar(navController = navController) }) {
        NavigateToScreen(navController = navController)

    }
}