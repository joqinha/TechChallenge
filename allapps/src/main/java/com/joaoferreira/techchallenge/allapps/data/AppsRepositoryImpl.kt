package com.joaoferreira.techchallenge.allapps.data

import android.util.Log
import com.google.gson.reflect.TypeToken
import com.joaoferreira.techchallenge.allapps.domain.AppData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class AppsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppsRepository {

    override fun getListApps(): Flow<List<AppData>> = flow {
        try {
            val response = apiService.listApps().execute()
            if (response.isSuccessful) {

                if (response.body()?.status == "OK") {
                    val apps = response.body()?.responses?.listApps?.datasets?.all?.data?.list
                        ?: emptyList()
                    Log.d("Teste", "getListApps: $apps")
                    emit(apps)
                } else {
                    Log.i("Teste", "getListApps: Unsuccessful response: ${response.body()?.status}")
                    emit(emptyList())
                }

            } else {
                Log.i("Teste", "getListApps: Unsuccessful response: ${response.code()}")
                emit(emptyList())
            }
        } catch (e: Exception) {
            Log.i("Teste", "getListApps: Exception ${e.message}")
            emit(emptyList())
        }
    }.flowOn(dispatcher)
}