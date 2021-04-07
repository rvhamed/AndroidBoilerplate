// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(BuildPlugins.ANDROID_GRADLE_PLUGIN)
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}

tasks.register<Copy>("installGitHook") {
    File(rootProject.rootDir, ".git/hooks/prepare-commit-msg").apply {
        if(exists())
            delete()
    }
    from(File(rootProject.rootDir, "scripts/git-hooks/prepare-commit-msg"))
    into(File(rootProject.rootDir, ".git/hooks"))
    fileMode = 0x777
}

tasks.getByPath(":app:preBuild").dependsOn(":installGitHook")