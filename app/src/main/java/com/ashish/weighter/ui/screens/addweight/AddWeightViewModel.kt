package com.ashish.weighter.ui.screens.addweight

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.weighter.persistance.Weight
import com.ashish.weighter.repository.WeightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddWeightViewModel @Inject() constructor(private val repository: WeightRepository) :
    ViewModel() {

    val defaultDate = LocalDate.now()!!
    val weightState = mutableStateOf("")
    val dateState = mutableStateOf(defaultDate.toString())

    fun onWeightChange(weight: String) {
        weightState.value = weight
    }

    fun onDateChange(date: String) {
        dateState.value = date
    }


    fun addWeight() = viewModelScope.launch {

        val weight = Weight(0, weightState.value, dateState.value)
        repository.addWeight(weight)
    }


}