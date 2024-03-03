package com.example.hilttest

import android.util.Log
import java.time.LocalDateTime

object AppStateImpl: AppState {
    override lateinit var initializationTime: LocalDateTime

    fun initialize(): AppState {
        initializationTime = LocalDateTime.now()
        Log.d("Init", "App state initialized at $initializationTime")
        return this
    }
}
