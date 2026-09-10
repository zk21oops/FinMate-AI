plugins {
    alias(libs.plugins.jetpack.library)
    alias(libs.plugins.jetpack.dagger.hilt)
}

android {
    namespace = "dev.atick.core.android"
}

dependencies {
    // ... Core Android
    api(libs.androidx.core.ktx)

    // ... Coroutines
    api(libs.kotlinx.coroutines.android)

    // ... Serialization
    api(libs.kotlinx.serialization.json)

    // ... Date-Time
    api(libs.kotlinx.datetime)

    // ... Dagger-Hilt
    api(libs.dagger.hilt.android)

    // ... Logger
    api(libs.timber.logging)
}