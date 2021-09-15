package com.ashish.weighter.utils

import com.ashish.weighter.model.Weight

sealed class WeightState {

    // It Represents different states for fetching Current Weight

    object Empty : WeightState()
    object Loading : WeightState()
    data class Success(val weight: String) : WeightState()
    data class Error(val exception: Throwable) : WeightState()
}