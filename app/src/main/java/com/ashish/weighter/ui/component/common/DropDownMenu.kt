package com.ashish.weighter.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashish.weighter.ui.theme.WeighterTheme
import com.ashish.weighter.ui.theme.background

@Composable
fun DropDownMenu() {
    var expandedState by remember { mutableStateOf(false) }

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    val items = listOf("Week", "Month", "Year")
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .background(shape = RoundedCornerShape(50), color = background)
        .width(100.dp)
        .height(32.dp)
        .shadow(elevation = 1.dp , shape = RoundedCornerShape(50))
        .animateContentSize(animationSpec = tween(durationMillis = 300,
            easing = LinearOutSlowInEasing)),
        contentAlignment = Alignment.Center


    )

    {
        Column(
            modifier = Modifier
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(items[selectedIndex], modifier = Modifier
                    .clickable(onClick = { expandedState = true }))
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandedState) {
                DropdownMenu(
                    expanded = expandedState,
                    onDismissRequest = { expandedState = false },
                    modifier = Modifier
                        .wrapContentWidth()
                        .background(
                            Color.White)
                ) {
                    items.forEachIndexed { index, weightUnit ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expandedState = false
                        }) {

                            Text(text = weightUnit)
                        }
                    }
                }
            }
        }


    }
}

@Preview
@Composable
fun DropDownMenuPrv() {

    WeighterTheme {
        DropDownMenu()

    }

}