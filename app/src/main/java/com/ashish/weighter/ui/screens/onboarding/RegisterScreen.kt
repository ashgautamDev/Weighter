package com.ashish.weighter.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ashish.weighter.R
import com.ashish.weighter.ui.component.BgChangeableButton
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.theme.textColor

@Composable
fun RegisterScreen() {
    Column(modifier = Modifier.background(background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_signup_vector), contentDescription = null)

        // Welcome Text
        var titleText by remember { mutableStateOf("eg: Ashish " ) }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background),
            value = titleText,
            onValueChange = { titleText = it },
            textStyle = TextStyle( color = textColor.copy(alpha = 0.7f))

        )
    }
        BgChangeableButton("All Set")



    }