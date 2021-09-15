package com.ashish.weighter.database

import androidx.compose.ui.Modifier
import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashish.weighter.model.Weight

@Database(entities = [Weight::class] , version = 1 ,exportSchema = false)
abstract class WeightDatabase : RoomDatabase() {
    abstract fun getWeightDao() : WeightDao
}