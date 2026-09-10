plugins {
    alias(libs.plugins.jetpack.library)
    alias(libs.plugins.jetpack.dagger.hilt)
}

android {
    namespace = "dev.atick.bluetooth.classic"
}

dependencies {
    implementation(project(":core:android"))
    api(project(":bluetooth:common"))
}