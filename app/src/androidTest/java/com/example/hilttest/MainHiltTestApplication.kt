package com.example.hilttest

import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(MainApplication::class)
interface MainHiltTestApplication
