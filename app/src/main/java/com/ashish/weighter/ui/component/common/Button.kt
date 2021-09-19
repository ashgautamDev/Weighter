package com.ashish.weighter.ui.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BgChangeableButton(text : String,
                       bgColor: Color = MaterialTheme.colors.primaryVariant,
                       elevation: ButtonElevation = ButtonDefaults.elevation(4.dp)
) {
    var isClicked by remember { mutableStateOf(false) }

    val colors = if (isClicked) bgColor else MaterialTheme.colors.surface

    Button(
        onClick = { isClicked = !isClicked
            Log.d("BgButton"    , "BgChangeableButton: button is $isClicked ")
        } ,
        colors = ButtonDefaults.buttonColors(backgroundColor = colors) ,
        elevation = elevation ,
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Text(text = text , Modifier.padding(8.dp))
    }
}