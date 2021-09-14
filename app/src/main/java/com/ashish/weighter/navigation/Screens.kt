package com.ashish.weighter.navigation

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ashish.weighter.ui.view.screens.AddWeightScreen
import com.ashish.weighter.ui.view.screens.MyWeightScreen
import com.ashish.weighter.ui.view.screens.TargetScreen

sealed class Screens(var route : String, var icon : ImageVector, var title : String){
    object MyWeight : Screens("home" , Icons.Default.AccountBox , "My Weight")
    object Target : Screens("target", Icons.Default.AccountCircle , "Target")
    object AddWeight : Screens("add" , Icons.Default.AddCircle , "")
}

@Composable
fun NavigateToScreen(navController: NavHostController) {
    NavHost(navController, startDestination = Screens.MyWeight.route){
        composable(Screens.MyWeight.route){
            MyWeightScreen()
        }
        composable(Screens.Target.route){
            TargetScreen()

        }
        composable(Screens.AddWeight.route){
            AddWeightScreen()
        }
    }

}