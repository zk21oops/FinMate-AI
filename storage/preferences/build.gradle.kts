plugins {
    alias(libs.plugins.jetpack.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jetpack.dagger.hilt)
}

android {
    namespace = "dev.atick.storage.preferences"
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    // ... Modules
    implementation(project(":core:android"))

    // ... DataStore
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
}