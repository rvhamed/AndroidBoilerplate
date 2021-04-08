package commons

import BuildPlugins
import build.AndroidSdk
import build.BuildType
import build.BuildTypeDebug
import build.BuildTypeStage
import com.android.build.gradle.BaseExtension
import dependencies.AndroidTestLibs
import dependencies.Libs
import dependencies.TestLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


open class BoilerPlatePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configurePlugins()
        project.configureAndroid()
        project.configureDependencies()
    }
}

fun Project.configurePlugins() {
    with(plugins) {
        apply(BuildPlugins.ANDROID_APPLICATION)
        apply(BuildPlugins.KOTLIN_ANDROID)
        apply(BuildPlugins.KOTLIN_KAPT)
    }
}

fun Project.configureDependencies() = dependencies {
    add("implementation", Libs.KOTLIN)
    add("implementation", Libs.CORE_KTX)
    add("implementation", Libs.APPCOMPAT)
    add("implementation", Libs.MATERIAL)
    add("implementation", Libs.CONSTRAIN_LAYOUT)
    add("testImplementation", TestLibs.JUNIT)
    add("androidTestImplementation", AndroidTestLibs.JUNIT)
    add("androidTestImplementation", AndroidTestLibs.ESPRESSO)
}