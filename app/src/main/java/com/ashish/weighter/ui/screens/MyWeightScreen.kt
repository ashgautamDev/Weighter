package com.ashish.weighter.ui.view.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashish.weighter.navigation.NavigateToScreen
import com.ashish.weighter.navigation.Screens
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.BottomNavigationBar
import com.ashish.weighter.ui.component.TopBar
import com.ashish.weighter.ui.component.WeightGraph
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.view.CurrentWeightInfoView
import com.ashish.weighter.ui.view.YourProgressView


@Composable
fun MyWeightScreen( viewmodel: WeightViewmodel ,navController : NavController ) {
val _currentWeight = viewmodel.getCurrentWeight()
    Scaffold(modifier = Modifier
        .background(color = background)
        .padding(16.dp),
        backgroundColor = background,
        topBar = {
            TopBar()

        },
         floatingActionButton = {
            Image(imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                modifier = Modifier.size(56.dp).background(color = MaterialTheme.colors.primary).clickable { navController.navigate(Screens.AddWeight.route)})
        },
        content = { padding ->
            Column(modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {

                CurrentWeightInfoView(currentWeight = _currentWeight.toString() , modifier = Modifier.padding(padding))
                WeightGraph()
                YourBmiView()
                YourProgressView()
            }
        }
    )


}



