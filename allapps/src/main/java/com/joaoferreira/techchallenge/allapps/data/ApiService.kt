package com.joaoferreira.techchallenge.allapps.data

import com.joaoferreira.techchallenge.allapps.domain.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/6/bulkRequest/api_list/listApps")
    fun listApps(): Call<ApiResponse>
}