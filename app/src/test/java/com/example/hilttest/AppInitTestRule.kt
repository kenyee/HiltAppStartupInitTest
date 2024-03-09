package com.example.hilttest

import android.content.Context
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.time.LocalDateTime

class AppInitTestRule(val targetContext: Context): TestRule {
    override fun apply(statement: Statement, description: Description): Statement =
        object: Statement() {
            override fun evaluate() {
                val appContext = targetContext.applicationContext as MainApplication
                appContext.appState = object : AppState {
                    private val creationTime = LocalDateTime.now()
                    override val initializationTime: LocalDateTime
                        get() = creationTime
                }

                statement.evaluate()
            }
        }
}
