package com.ashish.weighter.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashish.weighter.ui.theme.WeighterTheme

@Composable
fun Chip(
    option1: String,
    option2: String,
) {
    var opt1 by remember {
        mutableStateOf(true)
    }
    var opt2 by remember {
        mutableStateOf(false)
    }
val optionSelected = opt1 != opt2
    Row {
        Chip(selected = opt1, text = option1, modifier = Modifier.clickable {optionSelected })
        Spacer(modifier = Modifier.width(10.dp))
        Chip(selected = opt2, text = option2, modifier = Modifier.clickable {optionSelected })
    }

}


@Preview(showBackground = true)
@Composable
fun ChipPrv() {

    WeighterTheme() {
        Chip(option1 = "Kg", option2 = "Lbs")

    }
}