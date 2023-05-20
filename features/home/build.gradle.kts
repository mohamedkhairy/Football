
apply {
    from("$rootDir/android-library-build.gradle")
}

plugins {
        kotlin("plugin.serialization") version "1.8.21"
}


dependencies {

    val composeBom = platform(libs.composeBom)



    // Compose
    "implementation"(composeBom)
    "implementation"(libs.serialization)
    "implementation"(libs.bundles.jetpackCompost)
    "implementation"(libs.ktorAndroid)


}
