package commons

import build.AndroidSdk
import dependencies.Libs
import dependencies.TestLibs
import dependencies.AndroidTestLibs

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
}

android {
    compileSdkVersion(AndroidSdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidSdk.MIN_SDK_VERSION)
        targetSdkVersion(AndroidSdk.TARGET_SDK_VERSION)

        testInstrumentationRunner = AndroidSdk.TEST_RUNNER
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

dependencies {
    implementation(Libs.KOTLIN)
    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAIN_LAYOUT)
    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.ESPRESSO)
}