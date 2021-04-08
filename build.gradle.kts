
plugins.apply(BuildPlugins.GIT_HOOKS)

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}
