package commons

import build.AndroidSdk
import build.BuildType
import build.BuildTypeDebug
import build.BuildTypeStage
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Main configuration for all modules.
 *@author Hamed.Rahimvand
 *@since 4/8/21
 */
fun Project.configureAndroid() = this.extensions.getByType<AndroidBaseExtension>().run {

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

internal typealias AndroidBaseExtension = BaseExtension

