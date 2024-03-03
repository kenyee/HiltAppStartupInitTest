package com.example.hilttest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import junit.framework.TestCase.assertEquals
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@UninstallModules(AppConfigModule::class)
class DeviceInjectionTest {
    @Module
    @InstallIn(SingletonComponent::class)
    object TestModule {
        @Singleton
        @Provides
        fun provideConfig(): AppConfig = object : AppConfig {
            override val name: String
                get() = "DeviceTest"
        }
    }

    @get:Rule
    val appInitRule = AppInitTestRule(InstrumentationRegistry.getInstrumentation().targetContext)

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Inject
    lateinit var appConfig: AppConfig

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun useAppContext() {
        assertEquals(appConfig.name, "DeviceTest")
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.hilttest", appContext.packageName)
    }
}
