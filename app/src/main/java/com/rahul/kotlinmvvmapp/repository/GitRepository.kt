package com.rahul.kotlinmvvmapp.repository

import com.rahul.kotlinmvvmapp.models.ResponseClass
import com.rahul.kotlinmvvmapp.remote.ApiClient
import com.rahul.kotlinmvvmapp.remote.Network
import retrofit2.Response

class GitRepository {

    private val apiClient = Network.getInstance().create(ApiClient::class.java)

    suspend fun fetchResult(): Response<List<ResponseClass>> {
        return apiClient.fetchClosedPullsList()
    }
}