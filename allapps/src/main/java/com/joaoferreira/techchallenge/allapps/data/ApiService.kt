package com.joaoferreira.techchallenge.allapps.data

import com.joaoferreira.techchallenge.allapps.domain.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface to fetch info from external API
 * */
interface ApiService {
    /**
     * Method to get the list of apps
     */
    @GET("/api/6/bulkRequest/api_list/listApps")
    fun listApps(): Call<ApiResponse>
}
