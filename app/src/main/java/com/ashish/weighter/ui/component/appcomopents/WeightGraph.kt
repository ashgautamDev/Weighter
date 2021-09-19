package com.ashish.weighter.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.weighter.ui.theme.*

@Composable
fun WeightGraph() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp),
        border = BorderStroke(1.dp, color = textColor),
        backgroundColor = background ,
        shape = AbsoluteRoundedCornerShape(10)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.padding(16.dp)) {
            Column( Modifier.fillMaxHeight(1f).padding(bottom = 30.dp),verticalArrangement = Arrangement.SpaceEvenly) {
                TextNo(70)
                TextNo(60)
                TextNo(50)
                TextNo(40)
                TextNo(30)
                TextNo(20)
                TextNo(10)
            }
            DayProgress(day = "mon", dayProgress = .8f)
            DayProgress(day = "tue", dayProgress = .7f)
            DayProgress(day = "wed", dayProgress = .6f)
            DayProgress(day = "thu", dayProgress = .75f)
            DayProgress(day = "fri", dayProgress = .78f)
            DayProgress(day = "sat", dayProgress = .7f)
            DayProgress(day = "sun", dayProgress = .75f)


        }

    }
}

@Composable
fun TextNo(value : Int) {
    Text(text = value.toString() , color =  textDark.copy(alpha = .7f) , fontSize = 16.sp , fontWeight = FontWeight.SemiBold)

}

@Composable
fun DayProgress( day : String , dayProgress : Float) {
    Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxHeight()) {
       Box(modifier = Modifier
           .width(8.dp)
           .fillMaxHeight(dayProgress)
           .background(color = Color.Blue.copy(alpha = .6f) , shape = RoundedCornerShape(100)))
        Spacer(modifier = Modifier.heightIn(15.dp))
        Text(text = day.uppercase(),
            color = textDark.copy(alpha = .5f),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp)


    }
}
@Preview
@Composable
fun WeightGraphPrv() {
    WeighterTheme {
        WeightGraph()
    }
}