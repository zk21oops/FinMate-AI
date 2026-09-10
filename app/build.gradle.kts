@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Properties

val keystorePropertiesFile: File = rootProject.file("keystore.properties")

plugins {
    alias(libs.plugins.jetpack.application)
    alias(libs.plugins.jetpack.dagger.hilt)
    alias(libs.plugins.jetpack.firebase)
    alias(libs.plugins.secrets)
}

android {
    // ... Application Version ...
    val majorUpdateVersion = 1
    val minorUpdateVersion = 0
    val patchVersion = 3

    val mVersionCode = majorUpdateVersion.times(10_000)
        .plus(minorUpdateVersion.times(100))
        .plus(patchVersion)

    val mVersionName = "$majorUpdateVersion.$minorUpdateVersion.$patchVersion"
    val formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_a")
    val currentTime = LocalDateTime.now().format(formatter)

    defaultConfig {
        versionCode = mVersionCode
        versionName = mVersionName
        applicationId = "dev.atick.spend.wise"
    }

    signingConfigs {
        create("release") {
            if (keystorePropertiesFile.exists()) {
                val keystoreProperties = Properties()
                keystoreProperties.load(FileInputStream(keystorePropertiesFile))
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
                storeFile = file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
            }
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
//            applicationVariants.all {
//                outputs.all {
//                    (this as BaseVariantOutputImpl).outputFileName =
//                        rootProject.name.replace(" ", "_") + "_" +
//                                (buildType.name + "_v") +
//                                (versionName + "_") +
//                                "${currentTime}.apk"
//                    println(outputFileName)
//                }
//            }
            signingConfig = if (keystorePropertiesFile.exists()) {
                signingConfigs.getByName("release")
            } else {
                println("keystore.properties file not found. Using debug key.")
                signingConfigs.getByName("debug")

            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    namespace = "dev.atick.compose"
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":network"))
    implementation(project(":storage:room"))
    implementation(project(":storage:preferences"))
    implementation(project(":gemini"))
    implementation(project(":sms"))

    // ... Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // ... OSS Licenses
    implementation(libs.google.oss.licenses)

    // ... Billing
    implementation(libs.play.billing.ktx)

    // ... Work Manager
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.hilt.work)
    ksp(libs.androidx.hilt.compiler)

    // ... MPAndroidChart
    implementation(libs.androidchart)
}