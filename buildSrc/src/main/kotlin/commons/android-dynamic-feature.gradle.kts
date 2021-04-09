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
    id("com.android.dynamic-feature")
    id("kotlin-android")
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
            applicationIdSuffix = BuildTypeDebug.APP_SUFFIX_ID
            versionNameSuffix = BuildTypeDebug.VERSION_NAME_SUFFIX
        }

        create(BuildType.STAGING) {
            initWith(getByName(BuildType.DEBUG))
            applicationIdSuffix = BuildTypeStage.APP_SUFFIX_ID
            versionNameSuffix = BuildTypeStage.VERSION_NAME_SUFFIX
        }

        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }

    }
}

dependencies {
    implementation(project(Modules.APP))
    implementation(project(Modules.Common.UI))

    implementation(Libs.KOTLIN)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAIN_LAYOUT)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.ESPRESSO)
}
