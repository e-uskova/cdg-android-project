package com.example.cdg_android_project

import android.app.Application
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }

        MatchesDatabase.createDatabase(applicationContext)
    }
}
