plugins {
    alias(libs.plugins.jetpack.library)
    alias(libs.plugins.jetpack.dagger.hilt)
}

android {
    namespace = "dev.atick.storage.room"
}

dependencies {
    // ... Modules
    implementation(project(":core:android"))

    // ... Room
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
}