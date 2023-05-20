@file:Suppress( "DSL_SCOPE_VIOLATION")

apply {
    from("$rootDir/android-library-build.gradle")
}
plugins {
    alias(libs.plugins.ksp)
}

dependencies {


    "implementation"(libs.bundles.room)
    "ksp"(libs.roomCompiler)
}