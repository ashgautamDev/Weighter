package com.ashish.weighter.ui.screens.addweight

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.weighter.persistance.Weight
import com.ashish.weighter.repository.WeightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddWeightViewModel @Inject() constructor(private val repository: WeightRepository) :
    ViewModel() {

    val weightState = mutableStateOf("")
    val dateState = mutableStateOf("")

    fun onWeightChange(weight: String) {
        weightState.value = weight
    }

    fun onDateChange(date : String) {
        dateState.value = date
    }


    fun addWeight(context : Context) = viewModelScope.launch {

        val weight = Weight(0, weightState.value, dateState.value)
        if (inputCheck(weight.weight)) {
            repository.addWeight(weight)
        } else
        {
            Toast.makeText(context, "Please Enter Weight", Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(title : String) : Boolean{
        return !(TextUtils.isEmpty(title))
    }
}