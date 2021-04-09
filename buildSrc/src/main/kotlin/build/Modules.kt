package build

/**
 *
 *@author Hamed.Rahimvand
 *@since 4/6/21
 */
object Modules {
    const val APP = ":app"

    object Features{
        const val DASHBOARD = ":features:dashboard"
        const val LAUNCHERS = ":features:launchers"
    }

    object Common{
        const val UI = ":common:ui"
    }
}