package com.ashish.weighter.ui.screens.addweight


import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashish.weighter.navigation.AddScreen
import com.ashish.weighter.ui.theme.background
import com.ashish.weighter.ui.theme.textColor
import com.ashish.weighter.ui.theme.textDark
import com.ashish.weighter.utils.showDatePicker
import java.time.LocalDate


@ExperimentalComposeUiApi
@Composable
fun AddWeightScreen(navController: NavController, viewModel: AddWeightViewModel) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
            .padding(bottom = 56.dp),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Cancel", fontSize = 20.sp, modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Start)
                .clickable {
                    navController.navigate(AddScreen.MainScreen.route)
                }, color = background,
            fontWeight = FontWeight.SemiBold
        )

        WeightData(viewModel)

        Button(
            onClick = {
                if (inputCheck(viewModel.weightState.value)) {
                    viewModel.addWeight()
                    navController.navigate(AddScreen.MainScreen.route)
                    Toast.makeText(context, "Weight Added", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, "Please Enter Weight", Toast.LENGTH_SHORT).show()
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = background,
                contentColor = textDark
            ),
            shape = AbsoluteRoundedCornerShape(10)
        ) {

            Text(text = "Done", fontSize = 18.sp)

        }

    }

}


@ExperimentalComposeUiApi
@Composable
fun WeightData(viewModel: AddWeightViewModel) {

    val selDate = LocalDate.now()
    val date = viewModel.dateState.value
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp),
        modifier = Modifier
            .drawBehind {
                drawCircle(
                    color = textColor.copy(alpha = .5f),
                    radius = 450f,
                    style = Stroke(width = 1.dp.toPx())
                )
            }

    ) {

        OutlinedTextField(
            value = viewModel.weightState.value,
            onValueChange = { viewModel.onWeightChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            singleLine = true,
            label = {
                Text(
                    text = "Enter Weight", textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            },
            textStyle = TextStyle(
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White.copy(alpha = .7f),
                unfocusedBorderColor = Color.White.copy(alpha = .7f)
            )
        )



        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                    .clickable { }
        )
        {

            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
            )
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

private fun inputCheck(title: String): Boolean {
    return !(TextUtils.isEmpty(title))
}




