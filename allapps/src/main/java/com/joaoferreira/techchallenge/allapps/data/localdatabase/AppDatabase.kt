package com.joaoferreira.techchallenge.allapps.data.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * Room database
 * */
@Database(entities = [AppInfo::class], version = 1)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Method to access AppDatabase
     */
    abstract fun appsDao(): AppDao
}
