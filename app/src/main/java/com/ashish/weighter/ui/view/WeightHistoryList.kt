package com.ashish.weighter.ui.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashish.weighter.persistance.Weight
import com.ashish.weighter.ui.component.WeightCard

@Composable
fun WeightHistoryList(weight : List<Weight>, navController: NavController) {


    LazyColumn(
        modifier = Modifier.padding(
            start = 46.dp,
            top = 12.dp,
            end = 0.dp,
            bottom = 12.dp
        )
    ) {

        items(weight) { item ->
      WeightCard(weight = item)
            Spacer(modifier = Modifier.heightIn(10.dp))
        }

    }
}