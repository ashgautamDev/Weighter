package com.ashish.weighter.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector


//sealed class NavScreen(var route: String, var icon: ImageVector, var title: String) {
//
//    object MyWeight : NavScreen("home", Icons.Default.AccountBox, "My Weight")
//    object Target : NavScreen("history", Icons.Default.AccountCircle, "History")
//}

// NavTabs
enum class NavScreen(val label : String, val icon: ImageVector) {
    RECORD("record", Icons.Default.AccountCircle),
    WEIGHT("Home",  Icons.Default.AccountBox)

}

sealed class Screens(var route: String) {

    object MainScreen : Screens("mainScreen")
    object SplashScreen : Screens("splashScreen")
    object AddWeight : Screens("addWeight")

}
