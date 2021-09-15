package com.ashish.weighter.ui.screens


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashish.weighter.navigation.Screens
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.TopBar
import com.ashish.weighter.ui.component.WeightGraph
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.view.CurrentWeightInfoView
import com.ashish.weighter.ui.view.YourProgressView
import com.ashish.weighter.utils.WeightState


@Composable
fun MyWeightScreen(viewModel: WeightViewmodel, navController: NavController) {

    val context = LocalContext.current
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
                modifier = Modifier
                    .size(56.dp)
                    .background(color = MaterialTheme.colors.primary)
                    .clickable { navController.navigate(Screens.AddWeight.route) })
        },
        content = { padding ->
            Column(modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                when (val result = viewModel.weightState.collectAsState().value) {
                    is WeightState.Empty -> {

                        // Show null state of Weight
                        CurrentWeightInfoView(currentWeight = "0",
                            modifier = Modifier.padding(padding))

                    }
                    is WeightState.Error -> {
                        Toast.makeText(
                            context,
                            "Error ${result.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is WeightState.Success -> {
                        // pass Current Weight
                        CurrentWeightInfoView(currentWeight = result.weight,
                            modifier = Modifier.padding(padding))

                    }

                }
                WeightGraph()
                YourBmiView()
                YourProgressView()
            }
        }
    )


}



