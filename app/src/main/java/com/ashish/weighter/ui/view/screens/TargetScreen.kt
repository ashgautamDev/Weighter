package com.ashish.weighter.ui.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun TargetScreen() {

    Column(verticalArrangement = Arrangement.Center ,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text("This is Target Screen " , fontSize = 25.sp)
    }

}