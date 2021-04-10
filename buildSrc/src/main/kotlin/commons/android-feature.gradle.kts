package commons

import dependencies.*
import build.AndroidSdk
import build.BuildType
import build.BuildTypeDebug
import build.BuildTypeStage
import build.Modules
import dependencies.Libs
import dependencies.AndroidTestLibs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")

}

android {

    compileSdkVersion(AndroidSdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidSdk.MIN_SDK_VERSION)
        targetSdkVersion(AndroidSdk.TARGET_SDK_VERSION)
        buildToolsVersion(AndroidSdk.BUILD_VERSION_TOOLS)

        testInstrumentationRunner(AndroidSdk.TEST_RUNNER)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName(BuildType.DEBUG) {
            isDebuggable = BuildTypeDebug.isDebuggable
            versionNameSuffix = BuildTypeDebug.VERSION_NAME_SUFFIX
        }

        create(BuildType.STAGING) {
            initWith(getByName(BuildType.DEBUG))
            versionNameSuffix = BuildTypeStage.VERSION_NAME_SUFFIX
        }

        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

    }
}

dependencies {
    implementation(project(Modules.Common.UI))

    api(Libs.KOTLIN)
    api(Libs.APPCOMPAT)
    api(Libs.MATERIAL)
    api(Libs.CONSTRAIN_LAYOUT)

    api(Libs.NAVIGATION_UI)
    api(Libs.NAVIGATION_FRAGMENT)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.ESPRESSO)
}
