import dependencies.*

plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
}

dependencies{
    api(Libs.APPCOMPAT)
    api(Libs.FRAGMENT_KTX)
}