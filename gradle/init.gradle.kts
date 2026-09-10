val ktlintVersion = "0.48.1"

initscript {
    val spotlessVersion = "8.0.0"

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
    }
}

rootProject {
    subprojects {
        apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
        extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                targetExclude("**/build/**/*.kt")
                // FIXME: This no longer working after spotless updata
                // ktlint(ktlintVersion).userData(mapOf("android" to "true"))
                // Temp Fix
                ktlint(ktlintVersion)
            }
            groovy {
                target("**/*.gradle")
                targetExclude("**/build/**/*.gradle")
            }
            format("kts") {
                target("**/*.kts")
                targetExclude("**/build/**/*.kts")
            }
            format("xml") {
                target("**/*.xml")
                targetExclude("**/build/**/*.xml")
            }
        }
    }
}