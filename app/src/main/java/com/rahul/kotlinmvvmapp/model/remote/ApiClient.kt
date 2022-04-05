package com.rahul.kotlinmvvmapp.model.remote

import com.rahul.kotlinmvvmapp.model.models.ResponseClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("pulls")
    suspend fun fetchClosedPullsList(
        @Query("state") name: String = "closed",
    ): Response<List<ResponseClass>>
}