package com.ashish.weighter.ui.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.navigation.NavigateToScreen
import com.ashish.weighter.navigation.Screens
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