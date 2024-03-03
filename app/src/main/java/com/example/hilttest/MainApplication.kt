package com.example.hilttest

import android.app.Application

open class MainApplication: Application() {
    lateinit var appState: AppState

    override fun onCreate() {
        super.onCreate()

        if (!applicationContext.isTestRun) {
            appState = AppStateImpl.initialize()
        }
    }
}
