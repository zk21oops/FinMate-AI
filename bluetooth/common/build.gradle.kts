plugins {
    alias(libs.plugins.jetpack.library)
    alias(libs.plugins.jetpack.dagger.hilt)
}

android {
    namespace = "dev.atick.bluetooth.common"
}

dependencies {
    implementation(project(":core:android"))
}