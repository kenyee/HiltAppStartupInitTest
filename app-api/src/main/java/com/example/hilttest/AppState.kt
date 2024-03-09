package com.example.hilttest

import java.time.LocalDateTime

interface AppState {
    val initializationTime: LocalDateTime
}
