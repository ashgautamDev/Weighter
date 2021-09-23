package com.ashish.weighter.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ashish.weighter.ui.theme.background

@Composable
fun AppFab(icon: ImageVector = Icons.Default.AddCircle, onClick: () -> Unit) {
    Image(
        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
        imageVector = icon.apply { tintColor.blue },
        contentDescription = null,
        modifier = Modifier
            .size(66.dp)
            .clickable {
                onClick()
            },
        alpha = .8f)
}