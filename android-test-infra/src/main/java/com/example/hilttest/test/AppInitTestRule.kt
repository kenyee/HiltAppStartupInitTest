package com.example.hilttest.test

import android.content.Context
import com.example.hilttest.AppStateImpl
import com.example.hilttest.AppStateHost
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class AppInitTestRule(val targetContext: Context): TestRule {
    override fun apply(statement: Statement, description: Description): Statement =
        object: Statement() {
            override fun evaluate() {
                val appContext = targetContext.applicationContext as AppStateHost
                appContext.appState = AppStateImpl.initialize()

                statement.evaluate()
            }
        }
}
