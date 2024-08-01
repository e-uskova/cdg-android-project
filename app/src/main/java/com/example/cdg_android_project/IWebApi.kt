package com.example.cdg_android_project

import kotlinx.coroutines.flow.Flow

interface IWebApi {
    suspend fun getMatches(): Flow<Match>
}
