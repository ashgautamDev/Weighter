package com.ashish.weighter.ui.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.TopBar
import com.ashish.weighter.ui.component.WeightGraph
import com.ashish.weighter.ui.screens.MainActions
import com.ashish.weighter.ui.screens.YourBmiView
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.view.CurrentWeightInfoView
import com.ashish.weighter.ui.view.YourProgressView


@Composable
fun MyWeightScreen(
    viewModel: WeightViewmodel,
    mainActions: MainActions,
    navController: NavController,
) {

    val scrollableState = rememberScrollState()

    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .background(color = background)
            .padding(16.dp),
        backgroundColor = background,
        topBar = {
            TopBar()

        },
        content = { padding ->

            Column(modifier = Modifier
                .padding(top = 16.dp)
                .scrollable(scrollableState , orientation = Orientation.Vertical),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                CurrentWeightInfoView("74", modifier = Modifier)
                WeightGraph()
                YourBmiView()
                YourProgressView()
            }
        }
    )
}



