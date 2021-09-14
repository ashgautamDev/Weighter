package com.ashish.weighter.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ashish.weighter.R

@Composable
fun StarterScreen() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_login_vector), contentDescription = null)

        // Welcome Text
        Text(
            text = stringResource(R.string.welcometext), color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.Bold, fontSize = 24.sp
        )
        Text(
            text = stringResource(R.string.description), color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.Bold, fontSize = 24.sp
        )
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary, shape = MaterialTheme.shapes.large)) {
            Text(text = "Get Started", fontSize = 18.sp)

        }


    }
}