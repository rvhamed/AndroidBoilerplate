import build.*
import build.BuildType
import dependencies.AndroidTestLibs
import dependencies.Libs
import dependencies.TestLibs

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
}

android {
    compileSdkVersion(AndroidSdk.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = App.APPLICATION_ID

        versionCode(App.VERSION_CODE)
        versionName(App.VERSION_NAME)

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

    implementation(project(Modules.Common.UI))

    implementation(project(Modules.Features.DASHBOARD))
    implementation(project(Modules.Features.LAUNCHERS))

    implementation(Libs.NAVIGATION_FRAGMENT)
    implementation(Libs.NAVIGATION_UI)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.JUNIT)
    androidTestImplementation(AndroidTestLibs.ESPRESSO)
}