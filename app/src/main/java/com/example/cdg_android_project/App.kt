package com.example.cdg_android_project

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        MatchesDatabase.createDatabase(applicationContext)
    }
}
