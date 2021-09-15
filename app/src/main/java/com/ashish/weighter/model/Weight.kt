package com.ashish.weighter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Weights Table")
data class Weight(
    @PrimaryKey(autoGenerate = true)
    val id : Int ,
    @ColumnInfo(name = "My Current Weight")
    val weight: String ,
    @ColumnInfo(name = "Date of Weight Tracked")
    val date : String
)
