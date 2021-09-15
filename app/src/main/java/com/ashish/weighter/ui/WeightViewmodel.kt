package com.ashish.weighter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.weighter.model.Weight
import com.ashish.weighter.repository.WeightRepository
import com.ashish.weighter.utils.ViewState
import com.ashish.weighter.utils.WeightState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeightViewmodel @Inject() constructor(private val repository: WeightRepository) :
    ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    private val _currentWeightState = MutableStateFlow<WeightState>(WeightState.Loading)


    // Ui collects state from this flow
    val uiState = _uiState.asStateFlow()
    val weightState = _currentWeightState.asStateFlow()

    fun getCurrentWeight() = viewModelScope.launch {
        repository.getCurrentWeight().collect{ currentWeight->
            if (currentWeight.isEmpty()){
                _currentWeightState.value = WeightState.Empty
            } else
            {
                _currentWeightState.value = WeightState.Success(currentWeight)
            }
        }
    }

    fun insertWeight(weight: Weight) = viewModelScope.launch {
        repository.addWeight(weight)
    }
    fun deleteWeight(weight: Weight) = viewModelScope.launch {
        repository.deleteWeight(weight)
    }

    fun updateWeight(weight: Weight) = viewModelScope.launch {
        repository.addWeight(weight)
    }

    init {
        viewModelScope.launch {
            repository.getAllWeights().distinctUntilChanged().collect { weights ->

                if(weights.isNullOrEmpty()){
                    _uiState.value = ViewState.Empty
                } else
                {
                    _uiState.value = ViewState.Success(weights)
                }

            }
        }
    }
}