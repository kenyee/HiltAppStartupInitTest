package com.example.hilttest

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class AppConfigImpl @Inject constructor() : AppConfig {
    override val name: String
        get() = "From App"
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppConfigEntry {
    fun getAppConfig(): AppConfig
}
