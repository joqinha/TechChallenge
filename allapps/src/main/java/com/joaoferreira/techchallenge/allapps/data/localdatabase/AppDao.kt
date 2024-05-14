package com.joaoferreira.techchallenge.allapps.data.localdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {
    /**
     * Get all apps entries available in database
     */
    @Query("SELECT * FROM appsTable")
    suspend fun getAllApps(): List<AppInfo>

    /**
     * Delete all apps entries
     */
    @Query("DELETE FROM appsTable")
    suspend fun deleteAllEntries()

    /**
     * Delete an app entry
     */
    @Delete
    suspend fun deleteApp(app: AppInfo)

    /**
     * Delete an app entry
     */
    @Insert
    suspend fun insertApp(app: AppInfo)
}