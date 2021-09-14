package com.ashish.weighter.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.weighter.ui.component.DottedShape
import com.ashish.weighter.ui.theme.WeighterTheme
import com.ashish.weighter.ui.theme.progressColor
import com.ashish.weighter.ui.theme.textDark



@Composable
fun YourBmiView() {

    val myBMI = "23.0"
    Card(modifier = Modifier
        .fillMaxWidth(),
        shape = RoundedCornerShape(25), backgroundColor = progressColor.copy(alpha = 0.9f)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(text = "Your Bmi".uppercase(),
                color = textDark,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Row(modifier = Modifier
                .fillMaxWidth() , verticalAlignment = Alignment.Bottom) {
                Text(text = myBMI, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Normal", fontWeight = FontWeight.Light, fontSize = 8.sp ,
                    modifier = Modifier.padding(2.dp))
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    Modifier
                        .height(9.dp)
                        .fillMaxWidth(.27f)
                        .background(Color.Blue, shape = DottedShape(step = 8.dp))
                )
                Box(
                    Modifier
                        .height(9.dp)
                        .fillMaxWidth(.67f)
                        .background(Color.Green, shape = DottedShape(step = 8.dp))
                )

                Box(
                    Modifier
                        .height(9.dp)
                        .fillMaxWidth()
                        .background(Color.Red, shape = DottedShape(step = 8.dp))
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Row(modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
              BmiValue(value = 15)
              BmiValue(value = 18)
              BmiValue(value = 25)
              BmiValue(value =30 )
              BmiValue(value = 40)
            }

        }
    }
}

@Composable
fun BmiValue( value : Int) {
    Text(text = value.toString(), fontWeight = FontWeight.SemiBold, fontSize = 9.sp)
}

@Preview
@Composable
fun BMIPrv() {
    WeighterTheme {
        YourBmiView()

    }
}

