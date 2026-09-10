plugins {
    alias(libs.plugins.jetpack.ui.library)
    alias(libs.plugins.jetpack.dagger.hilt)
}

android {
    namespace = "dev.atick.billing"
}

dependencies {
    // ... Modules
    implementation(project(":core:ui"))

    // ... Billing
    implementation(libs.play.billing.ktx)
}