package com.example.cdg_android_project

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebApi : IWebApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fixturedownload.com/feed/json/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val networkService = retrofit.create(ApiForRetrofit::class.java )

    override suspend fun getMatches(): Flow<Match> {
        try {
            val response = networkService.matches()
            if (response.isSuccessful) {
                val matches = response.body()
                return flow {
                    matches
                        ?.forEach {match ->
                            emit(match)
                            Log.d("ApiForRetrofit", match.toString())
                        }
                }
            } else when (response.code()) {
                403 -> { Log.d("ApiForRetrofit", "Forbidden") }
                404 -> { Log.d("ApiForRetrofit", "Not found") }
                else -> throw AssertionError()
            }
        } catch (e: Exception) {
            Log.d("ApiForRetrofit", e.message.toString())
            return flow {
                emit(matchMock)
            }
        }
        return TODO("Provide the return value")
    }
}
