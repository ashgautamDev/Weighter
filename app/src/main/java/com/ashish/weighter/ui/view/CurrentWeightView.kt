package com.ashish.weighter.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ashish.weighter.ui.component.DropDownMenu
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.theme.textDark

@Composable
fun CurrentWeightInfoView(currentWeight: String = "0", modifier: Modifier) {

    Column(modifier = modifier
        .background(color = background)
        .fillMaxWidth()) {


        Text(text = "current Weight".uppercase(),
            color = textDark,
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            Text(text = currentWeight + "Kg", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
            DropDownMenu()

        }
    }
}

