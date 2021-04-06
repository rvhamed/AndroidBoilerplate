package build

/**
 *
 *@author Hamed.Rahimvand
 *@since 4/5/21
 */
interface BuildType {

    companion object {
        const val DEBUG = "debug"
        const val STAGING = "staging"
        const val RELEASE = "release"
    }

    val isDebuggable: Boolean
}

object BuildTypeDebug : BuildType {
    override val isDebuggable = true

    const val APP_SUFFIX_ID = ".debug"
    const val VERSION_NAME_SUFFIX = "-DEBUG"
}

object BuildTypeStage : BuildType {
    override val isDebuggable = true

    const val APP_SUFFIX_ID = ".int"
    const val VERSION_NAME_SUFFIX = "-INT"
}

object BuildTypeRelease : BuildType {
    override val isDebuggable = false

}