package com.ashish.weighter.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.screens.addweight.AddWeightScreen
import com.ashish.weighter.ui.screens.MyWeightScreen
import com.ashish.weighter.ui.screens.TargetScreen
import com.ashish.weighter.ui.screens.addweight.AddWeightViewModel

sealed class Screens(var route: String, var icon: ImageVector, var title: String) {
    object MyWeight : Screens("home", Icons.Default.AccountBox, "My Weight")
    object Target : Screens("target", Icons.Default.AccountCircle, "Target")
    object AddWeight : Screens("add", Icons.Default.AddCircle, "")
}

@ExperimentalComposeUiApi
@Composable
fun NavigateToScreen(navController: NavHostController, activity : AppCompatActivity) {
    NavHost(navController, startDestination = Screens.MyWeight.route) {
        composable(Screens.MyWeight.route) {

            val viewModel: WeightViewmodel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            MyWeightScreen( navController = navController, viewModel = viewModel)
        }
        composable(Screens.Target.route) {

            val viewModel: WeightViewmodel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            TargetScreen(viewModel , navController = navController)

        }
        composable(Screens.AddWeight.route) {

            val viewModel: AddWeightViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            AddWeightScreen(navController , viewModel = viewModel , activity )
        }
    }

}