package com.ashish.weighter.ui.screens.onboarding

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashish.weighter.R
import com.ashish.weighter.navigation.Screens
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun StarterScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(5000L)

            navController.navigate(Screens.MainScreen.route) {
                popUpTo(Screens.SplashScreen.route) {
                    inclusive = true
                }
            }
        }

    }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_login_vector), contentDescription = "Logo")

        // Welcome Text
        Text( modifier = Modifier.align(Alignment.CenterHorizontally) ,
            text = stringResource(R.string.welcometext), color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.Bold, fontSize = 24.sp
        )
        Text(
            text = stringResource(R.string.description), color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.Bold, fontSize = 24.sp ,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = { navController.navigate(Screens.MainScreen.route) }, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.large
                )
        ) {
            Text(text = "Get Started", fontSize = 18.sp , fontWeight = FontWeight.Bold)
        }


    }
}