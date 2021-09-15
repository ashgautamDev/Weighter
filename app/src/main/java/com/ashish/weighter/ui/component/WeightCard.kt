package com.ashish.weighter.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ashish.weighter.model.Weight

@Composable
fun WeightCard(weight : Weight) {

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = weight.date,
                color = MaterialTheme.colors.primary.copy(alpha = .7f),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold)
        }
        Text(text = weight.weight, color = Color.Green, fontSize = 24.sp, fontWeight = FontWeight.Bold)

    }


}