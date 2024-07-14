package com.example.cdg_android_project

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WebApi {

    fun getMatches() : Flow<String> {
        return flow<String> {
            for (i in 0..20) {
                emit("Match #$i")
            }
        }
    }

}

