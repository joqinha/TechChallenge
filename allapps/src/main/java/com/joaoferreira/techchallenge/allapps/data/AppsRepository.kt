package com.joaoferreira.techchallenge.allapps.data

import com.joaoferreira.techchallenge.allapps.domain.AppDetails
import kotlinx.coroutines.flow.Flow

interface AppsRepository {
    fun getListApps(): Flow<List<AppDetails>>
}