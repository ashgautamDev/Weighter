package com.ashish.weighter.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashish.weighter.navigation.AddScreen
import com.ashish.weighter.ui.theme.background

@Composable
fun AppFab(navController : NavController , icon : ImageVector = Icons.Default.AddCircle ) {
    Image(
        imageVector = icon.apply { tintColor.blue },
        contentDescription = null,
        modifier = Modifier
            .size(56.dp)
            .background(color = background)
            .clickable { navController.navigate(AddScreen.AddWeight.route) },
        alpha = .8f)
}