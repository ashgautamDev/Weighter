package com.ashish.weighter.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavScreen(var route: String, var icon: ImageVector, var title: String) {

    object MyWeight : NavScreen("home", Icons.Default.AccountBox, "My Weight")
    object Target : NavScreen("history", Icons.Default.AccountCircle, "History")
}


sealed class AddScreen(var route: String) {

    object MainScreen : AddScreen("mainScreen")
    object AddWeight : AddScreen("addWeight")

}
