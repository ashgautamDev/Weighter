package com.ashish.weighter.persistance

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Weight::class] , version = 1 ,exportSchema = false)
abstract class WeightDatabase : RoomDatabase() {
    abstract fun getWeightDao() : WeightDao
}