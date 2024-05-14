package com.joaoferreira.techchallenge.allapps.di

import android.content.Context
import androidx.room.Room
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppDao
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "apps_database").build()
    }

    @Provides
    fun provideAppDao(database: AppDatabase): AppDao {
        return database.appsDao()
    }
}