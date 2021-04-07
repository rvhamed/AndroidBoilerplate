/**
 *
 *@author Hamed.Rahimvand
 *@since 4/5/21
 */
object BuildPlugins {
    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:" + Versions.BUILD_TOOLS
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"

    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val COMMON_ANDROID_DYNAMIC_FEATURE = "commons.android-dynamic-feature"
    const val KOTLIN_ANDROID = "kotlin-android"


}