package com.example.hilttest

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Installs FooModule in the generate SingletonComponent.
internal object AppConfigModule {
    @Singleton
    @Provides
    fun provideConfig(): AppConfig = AppConfigImpl()
}
