import build.*

plugins {
    id(BuildPlugins.ANDROID_DYNAMIC_FEATURE_PLUGIN)
}

dependencies {
    implementation(project(Modules.Features.DASHBOARD))
}