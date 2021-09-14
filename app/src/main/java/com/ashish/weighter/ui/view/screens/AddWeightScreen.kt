package com.ashish.weighter.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddWeightScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { "cancel" }
            )
        } ,
        content = {}
    )
}

@Composable
fun WeightData(weight : String) {
    var weight by remember {
        mutableStateOf(weight)
    }

    Column() {
        Text(text = "Enter Weight")
        TextField(value = weight , onValueChange = { weight = it})
        Button(onClick = { /*TODO*/ } , modifier = Modifier.fillMaxWidth()) {
            Text(text = "Done" , fontSize = 18.sp)

        }
    }

}