package com.example.hilttest

import android.app.Application

open class MainApplication: Application(), AppStateHost {
    override lateinit var appState: AppState

    override fun onCreate() {
        super.onCreate()

        if (!applicationContext.isTestRun) {
            appState = com.example.hilttest.AppStateImpl.initialize()
        }
    }
}
