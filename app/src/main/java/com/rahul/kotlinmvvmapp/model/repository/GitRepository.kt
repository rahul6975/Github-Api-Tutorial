package com.rahul.kotlinmvvmapp.model.repository

import com.rahul.kotlinmvvmapp.model.models.ResponseClass
import com.rahul.kotlinmvvmapp.model.remote.ApiClient
import com.rahul.kotlinmvvmapp.model.remote.Network
import retrofit2.Response

class GitRepository {

    private val apiClient = Network.getInstance().create(ApiClient::class.java)

    suspend fun fetchResult(): Response<List<ResponseClass>> {
        return apiClient.fetchClosedPullsList()
    }
}