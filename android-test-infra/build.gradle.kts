plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.hilttest.test"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        // Enabling multidex support.
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    coreLibraryDesugaring(libs.android.desugar)

    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.test.runner)
    implementation(libs.androidx.test.rules)

    implementation(project(":app-api"))
    implementation(project(":app-state"))
}