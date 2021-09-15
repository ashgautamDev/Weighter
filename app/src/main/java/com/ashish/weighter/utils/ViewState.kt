package com.ashish.weighter.utils

import com.ashish.weighter.model.Weight

sealed class ViewState {

    // It Represents different states for Weights

    object Empty : ViewState()
    object Loading : ViewState()
    data class Success(val weight: List<Weight>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}