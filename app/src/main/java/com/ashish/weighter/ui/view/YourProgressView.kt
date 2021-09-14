package com.ashish.weighter.ui.view

import android.widget.ProgressBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.weighter.ui.theme.WeighterTheme
import com.ashish.weighter.ui.theme.progressCardColor
import com.ashish.weighter.ui.theme.progressColor
import com.ashish.weighter.ui.theme.textDark

@Composable
fun YourProgressView() {

    val currentWeight = 64
    val leftWeight = 14
    val targetWeight = 50
val progressBar = 0.4f
    Card(modifier = Modifier
        .fillMaxWidth(),
        shape = RoundedCornerShape(25), backgroundColor = progressColor.copy(alpha = 0.9f)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Text(text = "your progress".uppercase(),
                color = textDark,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Row(modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Current", fontWeight = FontWeight.Light, fontSize = 8.sp)
                Text(text = "Left", fontWeight = FontWeight.Light, fontSize = 8.sp)
                Text(text = "Target", fontWeight = FontWeight.Light, fontSize = 8.sp)
            }
            Row(modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = currentWeight.toString() + "kg", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = leftWeight.toString() + "kg", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = targetWeight.toString() + "kg", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(6.dp))
            LinearProgressIndicator( modifier = Modifier.fillMaxWidth().height(8.dp).shadow(shape = RoundedCornerShape(100) , elevation = 0.dp)   , progress = progressBar , color =  MaterialTheme.colors.secondary , backgroundColor = progressColor )
        }
    }

}

@Preview
@Composable
fun ProgressPrv() {
    WeighterTheme {
        YourProgressView()

    }
}