package com.ashish.weighter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.screens.MyWeightScreen
import com.ashish.weighter.ui.screens.TargetScreen
import com.ashish.weighter.ui.screens.addweight.AddWeightScreen
import com.ashish.weighter.ui.screens.addweight.AddWeightViewModel

@ExperimentalComposeUiApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()


    NavHost(navController, startDestination = NavScreen.MyWeight.route) {


        composable(NavScreen.MyWeight.route) {

            val viewModel: WeightViewmodel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            MyWeightScreen(navController = navController, viewModel = viewModel)
        }
        composable(NavScreen.Target.route) {

            val viewModel: WeightViewmodel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            TargetScreen(viewModel, navController = navController)
        }
        composable(AddScreen.AddWeight.route) {
            val viewModel: AddWeightViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )

            AddWeightScreen(navController, viewModel)

        }

    }

}
