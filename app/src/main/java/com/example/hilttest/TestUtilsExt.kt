package com.example.hilttest

import android.content.Context
import android.content.pm.ApplicationInfo

// From https://stackoverflow.com/questions/6776689/is-it-possible-to-find-out-if-an-android-application-runs-as-part-of-an-instrume

private var wasTestRun = 0xDEAD

val Context.isTestRun: Boolean
    get() {
        if (wasTestRun != 0xDEAD) {
            return wasTestRun != 0
        }
        // Ignore release builds (as App may be using JUnit by mistake).
        if (isDebuggable) {
            try {
                Class.forName("org.junit.runner.Runner");
                wasTestRun = 1
                return true
            } catch (_: ClassNotFoundException) {
            }
        }
        wasTestRun = 0
        return false
    }

val Context.isDebuggable: Boolean
    get() = (applicationContext.applicationInfo.flags and
            ApplicationInfo.FLAG_DEBUGGABLE) != 0
