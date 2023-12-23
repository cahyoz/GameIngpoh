package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    suspend fun getList(): ListGameResponse
}