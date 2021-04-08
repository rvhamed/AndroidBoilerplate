package commons

import BuildPlugins
import build.Modules
import dependencies.AndroidTestLibs
import dependencies.Libs
import dependencies.TestLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
/**
 * Plugin for dynamic features. Usage:
 * Add below code to you feature to apply this plugin.
 * plugins {
 *  id("boilerplate-dynamic-feature-plugin")
 * }
 *
 *@author Hamed.Rahimvand
 *@since 4/8/21
 */
open class BoilerPlateDynamicFeaturePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureDynamicFeaturePlugins()
        project.configureAndroid()
        project.configureDynamicFeatureDependencies()
    }
}

fun Project.configureDynamicFeaturePlugins() {
    with(plugins) {
        apply(BuildPlugins.ANDROID_DYNAMIC_FEATURE)
        apply(BuildPlugins.KOTLIN_ANDROID)
        apply(BuildPlugins.KOTLIN_KAPT)
    }
}

fun Project.configureDynamicFeatureDependencies() = dependencies {
    add("implementation", project(Modules.APP))
    add("implementation", Libs.KOTLIN)
    add("implementation", Libs.CORE_KTX)
    add("implementation", Libs.APPCOMPAT)
    add("implementation", Libs.MATERIAL)
    add("implementation", Libs.CONSTRAIN_LAYOUT)
    add("testImplementation", TestLibs.JUNIT)
    add("androidTestImplementation", AndroidTestLibs.JUNIT)
    add("androidTestImplementation", AndroidTestLibs.ESPRESSO)
}