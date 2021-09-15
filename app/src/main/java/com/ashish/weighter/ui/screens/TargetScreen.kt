package com.ashish.weighter.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.EmptyScreen
import com.ashish.weighter.ui.view.WeightHistoryList
import com.ashish.weighter.utils.ViewState

@Composable
fun TargetScreen(viewModel: WeightViewmodel , navController: NavController ) {

    Column(verticalArrangement = Arrangement.Center ,
    horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current

        // observe Weights
        when (val result = viewModel.uiState.collectAsState().value) {
            is ViewState.Empty -> { EmptyScreen(navController = navController)}
            is ViewState.Error -> {
                Toast.makeText(
                    context,
                    "Error ${result.exception}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            is ViewState.Success -> {
               // pass result to Card
              WeightHistoryList(weight = result.weight, navController = navController)
            }

        }
    }

}