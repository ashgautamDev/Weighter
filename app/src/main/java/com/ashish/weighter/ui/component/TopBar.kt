package com.ashish.weighter.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.weighter.R
import com.ashish.weighter.ui.theme.textDark

@Composable
fun TopBar() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "My Weight ",
            fontSize = 28.sp,
            color = textDark,
            fontWeight = FontWeight.SemiBold
        )

        Image(painter = painterResource(id = R.drawable.ic_fmale_avatar), contentDescription = null ,)

    }
}


@Preview
@Composable
fun TopBarPrev() {

    TopBar()

}

