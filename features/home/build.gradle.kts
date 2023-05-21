@file:Suppress( "DSL_SCOPE_VIOLATION")

apply {
    from("$rootDir/android-library-build.gradle")
    from("$rootDir/native-library-build.gradle")
}

plugins {
    alias(libs.plugins.ksp)
    kotlin("plugin.serialization") version "1.8.21"
}


dependencies {

    val composeBom = platform(libs.composeBom)

    "implementation"(composeBom)
    "implementation"(libs.serialization)
    "implementation"(libs.bundles.jetpackCompost)
    "implementation"(libs.hiltNavigationCompose)
    "implementation"(libs.ktorAndroid)
    "implementation"(libs.bundles.archComponents)
    "implementation"(libs.bundles.kotlinCoroutines)
    "implementation"(libs.bundles.room)
    "ksp"(libs.roomCompiler)
    "implementation"(project(":core:network"))
    "implementation"(project(":core:utils"))


}
