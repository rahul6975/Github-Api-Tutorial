package com.rahul.kotlinmvvmapp.remote

import com.rahul.kotlinmvvmapp.models.ResponseClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("pulls")
    suspend fun fetchClosedPullsList(
        @Query("state") name: String = "closed",
    ): Response<List<ResponseClass>>
}