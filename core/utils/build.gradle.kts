
apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {

    val composeBom = platform(libs.composeBom)
    "implementation"(composeBom)
    "implementation"(libs.bundles.jetpackCompost)

}
