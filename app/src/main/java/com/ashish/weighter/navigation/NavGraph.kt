package com.ashish.weighter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.screens.MainActions
import com.ashish.weighter.ui.screens.MainScreen
import com.ashish.weighter.ui.screens.addweight.AddWeightScreen
import com.ashish.weighter.ui.screens.addweight.AddWeightViewModel

@ExperimentalComposeUiApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    val selectedTab = remember { mutableStateOf(NavScreen.WEIGHT) }


    NavHost(navController, startDestination = AddScreen.MainScreen.route) {


        composable(AddScreen.MainScreen.route) {

            val viewModel: WeightViewmodel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            MainScreen(viewModel ,actions, selectedTab)
        }


        composable(AddScreen.AddWeight.route) {
            val viewModel: AddWeightViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            AddWeightScreen(navController, viewModel)

        }

    }

}
