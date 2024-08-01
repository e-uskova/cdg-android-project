package com.example.cdg_android_project

import retrofit2.Response
import retrofit2.http.GET

interface ApiForRetrofit {
    @GET("epl-2023")
    suspend fun matches(): Response<List<Match>>
}
