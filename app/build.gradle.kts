import dependencies.AndroidTestLibs
import dependencies.TestLibs
import dependencies.Libs
import build.AndroidSdk
import build.BuildType
import build.BuildTypeRelease
import build.BuildTypeStage
import build.BuildTypeDebug
plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
}

android {
    compileSdkVersion(AndroidSdk.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidSdk.MIN_SDK_VERSION)
        targetSdkVersion(AndroidSdk.TARGET_SDK_VERSION)

        applicationId(build.App.APPLICATION_ID)
        versionCode(build.App.VERSION_CODE)
        versionName(build.App.VERSION_NAME)
        buildToolsVersion(AndroidSdk.BUILD_VERSION_TOOLS)

        testInstrumentationRunner(AndroidSdk.TEST_RUNNER)
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isDebuggable = BuildTypeRelease.isDebuggable
        }
        create(BuildType.STAGING) {
            isDebuggable = BuildTypeStage.isDebuggable
            applicationIdSuffix = BuildTypeStage.APP_SUFFIX_ID
            versionNameSuffix = BuildTypeStage.VERSION_NAME_SUFFIX
        }
        getByName(BuildType.DEBUG) {
            isDebuggable = BuildTypeDebug.isDebuggable
            applicationIdSuffix = BuildTypeDebug.APP_SUFFIX_ID
            versionNameSuffix = BuildTypeDebug.VERSION_NAME_SUFFIX
        }

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
    testImplementation (TestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.ESPRESSO)
}