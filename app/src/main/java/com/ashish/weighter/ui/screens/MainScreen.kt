package com.ashish.weighter.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ashish.weighter.navigation.Screens
import com.ashish.weighter.navigation.NavScreen
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.AppFab
import com.ashish.weighter.ui.screens.home.MyWeightScreen
import com.ashish.weighter.ui.screens.home.TargetScreen
import com.ashish.weighter.ui.theme.textDark


@ExperimentalComposeUiApi
@Composable
fun MainScreen(
    viewModel: WeightViewmodel,
    action: MainActions,
    selectedTab: MutableState<NavScreen>,
    navController: NavController,
) {

    Scaffold(

        floatingActionButton = {
            AppFab() {
//                mainActions.addWeight
                navController.navigate(Screens.AddWeight.route)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
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
                        selectedContentColor = textDark,
                    )
                }
            }
        },
    ) {
        val modifier = Modifier.padding(it)
        when (selectedTab.value) {
            NavScreen.RECORD -> TargetScreen(viewModel, navController)
            NavScreen.WEIGHT -> MyWeightScreen(viewModel, action, navController)

        }

    }
//    backHandler(
//        enabled = selectedTab.value != NavScreen.WEIGHT,
//        onBack = { selectedTab.value = NavScreen.WEIGHT }
//    )

}


class MainActions(navController: NavHostController) {

    val addWeight = {
        navController.navigate(Screens.AddWeight.route)
    }
}
