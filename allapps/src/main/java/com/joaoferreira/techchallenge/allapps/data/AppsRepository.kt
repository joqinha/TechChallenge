package com.joaoferreira.techchallenge.allapps.data

import com.joaoferreira.techchallenge.allapps.domain.AppDetails
import kotlinx.coroutines.flow.Flow

/**
 * Interface for listing all the apps available
 * */
interface AppsRepository {
    /**
     * Method to get all the apps in the repository
     */
    fun getListApps(): Flow<List<AppDetails>>
}
