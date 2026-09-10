plugins {
    alias(libs.plugins.android.library) apply(false)
    alias(libs.plugins.android.application) apply(false)
    alias(libs.plugins.kotlin.serialization) apply(false)
    alias(libs.plugins.dagger.hilt.android) apply(false)
    alias(libs.plugins.firebase.crashlytics) apply(false)
    alias(libs.plugins.kotlin.compose.compiler) apply(false)
    alias(libs.plugins.google.oss.licenses) apply (false)
    alias(libs.plugins.secrets) apply(false)
    alias(libs.plugins.gms) apply(false)
    alias(libs.plugins.ksp) apply(false)
    alias(libs.plugins.dokka)
}

dependencies {
    dokka(project(":app"))

    // ... Core
    dokka(project(":core:android"))
    dokka(project(":core:ui"))
    dokka(project(":network"))
    dokka(project(":storage:preferences"))
    dokka(project(":storage:room"))


    // ... SMS
    dokka(project(":sms"))

    // ... Gemini
    dokka(project(":gemini"))

    // ... Dokka Plugins
    dokkaPlugin(libs.dokka.android.plugin)
    dokkaPlugin(libs.dokka.mermaid.plugin)
}

dokka {
    pluginsConfiguration.html {
        customAssets.from("docs/assets/logo-icon.svg")
        customStyleSheets.from("docs/assets/dokka.css")
    }
}
