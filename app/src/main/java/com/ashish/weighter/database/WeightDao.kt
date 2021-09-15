package com.ashish.weighter.database

import androidx.room.*
import com.ashish.weighter.model.Weight
import kotlinx.coroutines.flow.Flow


@Dao
interface WeightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeight( weight: Weight)

    @Delete
    suspend fun deleteWeight(weight: Weight)


    @Update
    suspend fun updateWeight(weight: Weight)

    @Query("SELECT * FROM `Weights Table` ORDER BY id ASC ")
    fun getAllWeights() : Flow<List<Weight>>

    @Query("SELECT `My Current Weight` FROM `Weights Table` ORDER BY `id` DESC LIMIT 1")
    fun getCurrentWeight() : Flow<String>

}