package com.ashish.weighter.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.navigation.AddScreen
import com.ashish.weighter.navigation.NavScreen
import com.ashish.weighter.navigation.backHandler
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.screens.home.MyWeightScreen
import com.ashish.weighter.ui.screens.home.TargetScreen


@ExperimentalComposeUiApi
@Composable
fun MainScreen(
    viewModel: WeightViewmodel,
    action: MainActions,
    selectedTab: MutableState<NavScreen>,
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier,
                backgroundColor = MaterialTheme.colors.background
            ) {
                for (tab in NavScreen.values()) {
                    BottomNavigationItem(
                        selected = selectedTab.value == tab,
                        label = { tab.label },
                        onClick = {
                            if (selectedTab.value == tab) return@BottomNavigationItem
                            selectedTab.value = tab
                        },
                        icon = {
                            Icon(imageVector = tab.icon, contentDescription = null)
                        },
                        unselectedContentColor = Color.LightGray,
                        selectedContentColor = MaterialTheme.colors.primary,
                    )
                }
            }
        },
    ) {
        val modifier = Modifier.padding(it)
        when (selectedTab.value) {
            NavScreen.RECORD -> TargetScreen(viewModel, navController)
            NavScreen.WEIGHT -> MyWeightScreen(viewModel, action , navController)

        }

    }
    backHandler(
        enabled = selectedTab.value != NavScreen.WEIGHT,
        onBack = { selectedTab.value = NavScreen.WEIGHT }
    )

}


class MainActions(navController: NavHostController) {

    val addWeight = {
        navController.navigate(AddScreen.AddWeight.route)
    }
}
