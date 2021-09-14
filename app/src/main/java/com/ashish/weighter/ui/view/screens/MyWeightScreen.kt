package com.ashish.weighter.ui.view.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.navigation.NavigateToScreen
import com.ashish.weighter.ui.component.BottomNavigationBar
import com.ashish.weighter.ui.component.TopBar
import com.ashish.weighter.ui.component.WeightGraph
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.view.CurrentWeightInfoView
import com.ashish.weighter.ui.view.YourProgressView


@Composable
fun MyWeightScreen() {

    Scaffold(modifier = Modifier
        .background(color = background)
        .padding(16.dp),
        backgroundColor = background,
        topBar = {
            TopBar()

        },
        content = { padding ->
            Column(modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {

                CurrentWeightInfoView(currentWeight = "72", modifier = Modifier.padding(padding))

                WeightGraph()
                YourBmiView()
                YourProgressView()
            }
        }
    )


}

@Preview
@Composable
fun MyWeightScreenPrv() {

    MyWeightScreen()


}


