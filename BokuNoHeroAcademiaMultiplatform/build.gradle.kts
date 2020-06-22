// Top-level build file where you can add configuration options common to all sub-projects/modules.

apply(plugin = "koin")

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        val kotlinVersion: String by project
        val koinVersion: String by project
        val sqlDelightVersion: String by project

        classpath("com.android.tools.build:gradle:4.2.0-alpha02")
        classpath("co.touchlab:kotlinnativecocoapods:0.9")

        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath(kotlin("gradle-plugin", kotlinVersion))

        classpath("org.koin:koin-gradle-plugin:$koinVersion")

        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}



allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url = "https://kotlin.bintray.com/kotlinx")
        maven(url = "https://dl.bintray.com/ekito/koin")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}