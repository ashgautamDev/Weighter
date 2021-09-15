package com.ashish.weighter.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashish.weighter.model.Weight
import com.ashish.weighter.navigation.Screens
import com.ashish.weighter.ui.WeightViewmodel
import com.ashish.weighter.ui.component.Chip
import com.ashish.weighter.ui.theme.WeighterTheme
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.theme.textColor
import com.ashish.weighter.ui.theme.textDark

@Composable
fun AddWeightScreen(navController: NavController, viewModel: WeightViewmodel) {

    var currentWeight by remember {
        mutableStateOf("")
    }

    var currentDate by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)
        .padding(bottom = 56.dp),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Cancle", fontSize = 16.sp, modifier = Modifier
            .padding(16.dp)
            .align(alignment = Alignment.Start)
            .clickable {
                navController.navigate(Screens.MyWeight.route)
            }, color = background)
        WeightData(currentWeight)
        Button(
            onClick = {
                // Save Weight to Local Database .
                val weight = Weight(0, currentWeight, currentDate)


                viewModel.insertWeight(weight = weight)

                navController.navigate(Screens.MyWeight.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = background,
                contentColor = textDark)
        ) {

            Text(text = "Done", fontSize = 18.sp)

        }

    }

}


@Composable
fun WeightData(weight: String) {
    var currentWeight by remember {
        mutableStateOf(weight)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp),
        modifier = Modifier
            .drawBehind {
                drawCircle(
                    color = textColor,
                    radius = 450f,
                    style = Stroke(width = 1.dp.toPx())
                )
            }
    ) {
        Text(text = "Enter Weight", color = Color.White.copy(alpha = .8f))
        TextField(value = currentWeight,
            onValueChange = { currentWeight = it },
            modifier = Modifier.background(color = MaterialTheme.colors.primary))
        Chip(option1 = "KG", option2 = "LBS")
    }

}

@Preview
@Composable
fun AddWeightprv() {
    WeighterTheme {
//        AddWeightScreen()
    }
}
