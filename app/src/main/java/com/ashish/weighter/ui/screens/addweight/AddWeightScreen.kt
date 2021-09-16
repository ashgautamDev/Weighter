package com.ashish.weighter.ui.screens.addweight


import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashish.weighter.navigation.Screens
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.theme.textColor
import com.ashish.weighter.ui.theme.textDark
import com.ashish.weighter.utils.showDatePicker
import java.time.LocalDate


@ExperimentalComposeUiApi
@Composable
fun AddWeightScreen(navController: NavController, viewModel: AddWeightViewModel , activity : AppCompatActivity) {
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)
        .padding(bottom = 56.dp),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Cancel", fontSize = 16.sp, modifier = Modifier
            .padding(16.dp)
            .align(alignment = Alignment.Start)
            .clickable {
                navController.navigate(Screens.MyWeight.route)
            }, color = background)

        WeightData(viewModel , activity )

        Button(
            onClick = {

                viewModel.addWeight(context)
                navController.navigate(Screens.MyWeight.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = background,
                contentColor = textDark)
        ) {

            Text(text = "Done", fontSize = 18.sp)

        }

    }

}


@ExperimentalComposeUiApi
@Composable
fun WeightData(viewModel: AddWeightViewModel , activity : AppCompatActivity) {

    val selDate = LocalDate.now()
    val date = viewModel.dateState.value
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp),
        modifier = Modifier
            .drawBehind {
                drawCircle(
                    color = textColor,
                    radius = 450f,
                    style = Stroke(width = 1.dp.toPx())
                )
            }

    ) {
        Text(text = "Enter Weight", color = Color.White.copy(alpha = .8f))

        TextField(
            value = viewModel.weightState.value,
            onValueChange = { viewModel.onWeightChange(it) },
            modifier = Modifier.background(color = MaterialTheme.colors.primary),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            singleLine = true)



        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Icon(imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    modifier = Modifier.clickable{ showDatePicker(activity)})
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = date)

        }
//       BasicTextField(value = viewModel.dateState.value,
//            onValueChange = { viewModel.onDateChange(it) },
//            modifier = Modifier.background(color = MaterialTheme.colors.primary), leadingIcon = {
//               
//            },
//            readOnly = true
//            
//            )
//        Chip(option1 = "KG", option2 = "LBS")
    }

}





