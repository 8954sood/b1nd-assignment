// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version(ProjectProperties.ANDROID_VERSION).apply(false)
    id ("com.android.library").version(ProjectProperties.ANDROID_VERSION).apply(false)
    id ("org.jetbrains.kotlin.android").version(ProjectProperties.JETBRAINS_KOTLIN).apply(false)
    id("androidx.navigation.safeargs").version("2.5.3").apply(false)

}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}