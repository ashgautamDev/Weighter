package com.ashish.weighter.repository

import com.ashish.weighter.database.WeightDao
import com.ashish.weighter.model.Weight
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class WeightRepository @Inject() constructor(private val weightDao: WeightDao) {

    fun getAllWeights(): Flow<List<Weight>> =
        weightDao.getAllWeights()

    fun getCurrentWeight(): Flow<String> =
        weightDao.getCurrentWeight()

    suspend fun addWeight(weight: Weight) = weightDao.addWeight(weight)
    suspend fun deleteWeight(weight: Weight) = weightDao.deleteWeight(weight)
    suspend fun updateWeight(weight: Weight) = weightDao.updateWeight(weight)

}