package com.joaoferreira.techchallenge.allapps.data

import android.util.Log
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppDao
import com.joaoferreira.techchallenge.allapps.data.localdatabase.AppInfo
import com.joaoferreira.techchallenge.allapps.data.networkmonitor.NetworkMonitor
import com.joaoferreira.techchallenge.allapps.domain.AppDetails
import com.joaoferreira.techchallenge.allapps.domain.network.NetworkStatus
import com.joaoferreira.techchallenge.allapps.domain.response.AppData
import com.joaoferreira.techchallenge.common.TAG
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation of AppsRepository
 */
class AppsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appDao: AppDao,
    private val networkMonitor: NetworkMonitor,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppsRepository {
    private val _appDetailsList = MutableStateFlow<List<AppDetails>>(emptyList())
    private val appDetailsList = _appDetailsList.asStateFlow()

    init {
        observeChangesInNetworking()
    }

    override fun getListApps(): Flow<List<AppDetails>> = appDetailsList

    @Suppress("ComplexCondition")
    private fun observeChangesInNetworking() {
        CoroutineScope(dispatcher).launch {
            networkMonitor.networkStatus.collect {
                Log.d(TAG, "observeChangesInNetworking: $it")
                if (it == NetworkStatus.INITIAL ||
                    it == NetworkStatus.AVAILABLE ||
                    it == NetworkStatus.BLOCKED_STATUS_CHANGED ||
                    it == NetworkStatus.LINK_PROPERTIES_CHANGED
                ) {
                    val fetchedApps = fetchAppDetailsFromApi()
                    updateDb(fetchedApps)
                    updateAppDetailsList(fetchedApps)
                } else if (it == NetworkStatus.LOST) {
                    val localApps = loadAppsFromLocalDb()
                    updateAppDetailsList(localApps)
                }
            }
        }
    }

    private fun updateAppDetailsList(updatedList: List<AppDetails>) {
        _appDetailsList.value = updatedList
        Log.d(TAG, "updateAppDetailsList: ${_appDetailsList.value}")
    }

    @Suppress("LabeledExpression", "TooGenericExceptionCaught")
    private suspend fun fetchAppDetailsFromApi(): List<AppDetails> {
        return withContext(dispatcher) {
            try {
                val response = apiService.listApps().execute()
                if (response.isSuccessful) {
                    if (response.body()?.status == "OK") {
                        val apps = response.body()?.responses?.listApps?.datasets?.all?.data?.list
                            ?: emptyList()
                        Log.d(TAG, "fetchAppDetailsFromApi: $apps")
                        val appDetailsList = convertListAppDataToAppDetails(apps)
                        return@withContext appDetailsList
                    } else {
                        val localApps = loadAppsFromLocalDb()
                        Log.d(
                            TAG,
                            "fetchAppDetailsFromApi: Unsuccessful status: " +
                                "${response.body()?.status}, " +
                                "List of apps: $localApps"
                        )
                        return@withContext localApps
                    }
                } else {
                    Log.d(
                        TAG,
                        "fetchAppDetailsFromApi: Unsuccessful response: ${response.code()}"
                    )
                }
            } catch (e: Exception) {
                Log.d(TAG, "fetchAppDetailsFromApi: Exception ${e.message}")
            }
            val localApps = loadAppsFromLocalDb()
            Log.d(
                TAG,
                "fetchAppDetailsFromApi: Error list of apps $localApps"
            )
            return@withContext localApps
        }
    }

    private suspend fun updateDb(appDetailsList: List<AppDetails>) {
        if (appDetailsList.isNotEmpty()) {
            Log.d(TAG, "updateDb: $appDetailsList")
            appDao.deleteAllEntries()
            val appInfoList = convertListAppDetailsToAppInfo(appDetailsList)
            appInfoList.forEach { appDao.insertApp(it) }
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private suspend fun loadAppsFromLocalDb(): List<AppDetails> {
        try {
            val appInfoList = appDao.getAllApps()
            if (appInfoList.isEmpty()) {
                Log.d(TAG, "loadAppsFromLocalDb: No data in DB")
                return emptyList()
            }
            val appDetailsList = mutableListOf<AppDetails>()
            for (appInfo in appInfoList) {
                val appDetails = AppDetails(
                    id = appInfo.id,
                    name = appInfo.name ?: "",
                    versionName = appInfo.versionName ?: "",
                    size = appInfo.size ?: 0,
                    downloads = appInfo.downloads ?: 0,
                    rating = appInfo.rating ?: 0.0,
                    iconUrl = appInfo.iconUrl ?: "",
                    graphicUrl = appInfo.graphicUrl ?: "",
                )
                appDetailsList.add(appDetails)
            }
            Log.d(TAG, "loadAppsFromLocalDb: $appDetailsList")
            return appDetailsList
        } catch (e: Exception) {
            Log.d(TAG, "loadAppsFromLocalDb: Exception ${e.message}")
            return emptyList()
        }
    }

    private fun convertListAppDataToAppDetails(appDataList: List<AppData>): List<AppDetails> {
        val appDetailsList = mutableListOf<AppDetails>()
        for (appData in appDataList) {
            val appDetails = AppDetails(
                id = appData.id,
                name = appData.name,
                versionName = appData.versionName,
                size = appData.size,
                downloads = appData.downloads,
                rating = appData.rating,
                iconUrl = appData.iconUrl,
                graphicUrl = appData.graphicUrl,
            )
            appDetailsList.add(appDetails)
        }
        return appDetailsList
    }

    private fun convertListAppDetailsToAppInfo(appDetailsList: List<AppDetails>): List<AppInfo> {
        val appInfoList = mutableListOf<AppInfo>()
        for (appDetails in appDetailsList) {
            val appInfo = AppInfo(
                id = appDetails.id,
                name = appDetails.name,
                size = appDetails.size,
                downloads = appDetails.downloads,
                rating = appDetails.rating,
                iconUrl = appDetails.iconUrl,
                graphicUrl = appDetails.graphicUrl,
            )
            appInfoList.add(appInfo)
        }
        return appInfoList
    }
}
