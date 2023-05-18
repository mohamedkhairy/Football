@file:Suppress( "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.plugin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
//    kotlin("plugin.serialization") version "1.8.21"


}

apply("../config.gradle.kts")


android {

    namespace = "${rootProject.extra.get("applicationId")}"
    compileSdk = Integer.valueOf("${rootProject.extra.get("compileSdk")}")

    defaultConfig {
        applicationId = "${rootProject.extra.get("applicationId")}"
        minSdk = Integer.valueOf("${rootProject.extra.get("minSdk")}")
        targetSdk = Integer.valueOf("${rootProject.extra.get("compileSdk")}")
        versionCode = Integer.valueOf("${rootProject.extra.get("versionCode")}")
        versionName = "${rootProject.extra.get("versionName")}"

        // Custom test runner to set up Hilt dependency graph
        testInstrumentationRunner = "${rootProject.extra.get("testRunner")}"
    }

    buildTypes {

        getByName("${rootProject.extra.get("debugBuildType")}") {
            isMinifyEnabled = false
        }

        getByName("${rootProject.extra.get("releaseBuildType")}") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            isMinifyEnabled = false

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "${rootProject.extra.get("composeVersion")}"
    }


}

dependencies {


    val composeBom = platform(libs.composeBom)


    implementation(libs.hilt)
    implementation(libs.hiltNavigationCompose)
    kapt(libs.hiltDaggerCompiler)

    // Compose
    implementation(composeBom)
    implementation(libs.bundles.jetpackCompost)



    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation (composeBom)
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    debugImplementation ("androidx.compose.ui:ui-tooling")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")
}