package com.joaoferreira.techchallenge.allapps.data.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

/**
 * Data class for the AppsDatabase
 */
@Entity(tableName = "appsTable")
data class AppInfo(
    @PrimaryKey val id: Long,
    val name: String? = "",
    val versionName: String? = "",
    val size: Long? = null,
    val downloads: Long? = null,
    val rating: Double? = null,
    val iconUrl: String? = "",
    val graphicUrl: String? = "",
)

/**
 * Auxiliary converters for json
 */
class ListStringConverter {
    /**
     * Auxiliary converters for json
     */
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",")
    }

    /**
     * Auxiliary converters for json
     */
    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }
}
