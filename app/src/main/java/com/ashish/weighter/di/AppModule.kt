package com.ashish.weighter.di

import android.content.Context
import androidx.room.Room
import com.ashish.weighter.database.WeightDao
import com.ashish.weighter.database.WeightDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDoa(weightDatabase: WeightDatabase): WeightDao =
        weightDatabase.getWeightDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeightDatabase =
        Room.databaseBuilder(
            context,
            WeightDatabase::class.java,
            "weights-db"
        ).fallbackToDestructiveMigration().build()
}