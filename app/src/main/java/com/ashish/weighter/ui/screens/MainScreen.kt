package com.ashish.weighter.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.navigation.NavigateToScreen
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.BottomNavigationBar
import com.ashish.weighter.ui.theme.WeighterTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {

        NavigateToScreen(navController = navController)

    }
}

@Preview
@Composable
fun MainScreenPrv() {
    WeighterTheme {
        MainScreen()
    }
}