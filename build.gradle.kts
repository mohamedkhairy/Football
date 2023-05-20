// Top-level build file where you can add configuration options common to all sub-projects/modules.

@file:Suppress("DSL_SCOPE_VIOLATION")


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.plugin) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.parcelize) apply false
}

buildscript {
    apply("config.gradle.kts")
}


//fun com.android.build.gradle.BaseExtension.baseConfig() {
//
//
//    namespace = "${rootProject.extra.get("applicationId")}"
//    compileSdkVersion( Integer.valueOf("${rootProject.extra.get("compileSdk")}"))
//
//
//    defaultConfig.apply {
//        minSdk = Integer.valueOf("${rootProject.extra.get("minSdk")}")
//        targetSdk = Integer.valueOf("${rootProject.extra.get("compileSdk")}")
//
//        testInstrumentationRunner = "${rootProject.extra.get("testRunner")}"
//    }
//
//    compileOptions.apply {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//
//    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//        kotlinOptions {
//            jvmTarget = "17"
//        }
//    }
//}

//
///**
// * Apply shared configurations to the android modules.
// */
//fun com.android.build.gradle.BaseExtension.baseConfig() {
//    plugins.withType<com.android.build.gradle.api.AndroidBasePlugin> {
//        configure<com.android.build.gradle.BaseExtension> {
//            defaultConfig {
//                compileOptions {
//
//                    compileSdkVersion(33)
//                    defaultConfig {
//                        minSdk = 23
//                        targetSdk = 33
//                    }
//
//                    sourceCompatibility = JavaVersion.VERSION_11
//                    targetCompatibility = JavaVersion.VERSION_11
//                }
//            }
//        }
//    }
//
//    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile> {
//        kotlinOptions.jvmTarget = "11"
//    }
//}
//
///**
// * Apply configuration settings that are shared across all modules.
// */
//fun PluginContainer.applyBaseConfig(project: Project) {
//    whenPluginAdded {
//        when (this) {
//            is com.android.build.gradle.internal.plugins.AppPlugin -> {
//                project.extensions
//                    .getByType<com.android.build.gradle.AppExtension>()
//                    .apply {
//                        baseConfig()
//                    }
//            }
//            is com.android.build.gradle.internal.plugins.LibraryPlugin -> {
//                project.extensions
//                    .getByType<com.android.build.gradle.LibraryExtension>()
//                    .apply {
//                        baseConfig()
//                    }
//            }
//        }
//    }
//}