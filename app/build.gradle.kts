import build.*
import build.BuildType
import dependencies.AndroidTestLibs
import dependencies.Libs
import dependencies.TestLibs

plugins {
    id(BuildPlugins.BOILERPLATE_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID)
}

android {
    defaultConfig {
        applicationId = App.APPLICATION_ID

        versionCode(App.VERSION_CODE)
        versionName(App.VERSION_NAME)
    }

    buildTypes {
        getByName(BuildType.DEBUG) {}
        getByName(BuildType.STAGING) {}
        getByName(BuildType.RELEASE) {}
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dynamicFeatures = mutableSetOf(Modules.Features.DASHBOARD)
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