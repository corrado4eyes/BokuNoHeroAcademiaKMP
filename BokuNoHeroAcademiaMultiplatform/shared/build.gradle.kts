import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("co.touchlab.native.cocoapods")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

kotlin {
    android()
    //Revert to just ios() when gradle plugin can properly resolve it
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos")?:false
    if(onPhone){
        iosArm64("ios")
    }else{
        iosX64("ios")
    }
    targets.getByName<KotlinNativeTarget>("ios").compilations["main"].kotlinOptions.freeCompilerArgs +=
        listOf("-Xobjc-generics", "-Xg0")

    version = "1.1"

    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }

        val kotlinVersion: String by project
        val sqlDelightVersion: String by project
        val commonKoinVersion: String by project
        val karmokVersion: String by project
        val androidxTextExtVersion: String by project
        val androidxTestVersion: String by project
        val nativeCoroutinesVersion: String by project

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common", kotlinVersion))

                // Common Deps

                // Touchlab
                implementation("co.touchlab:stately-common:1.0.2")
                implementation("co.touchlab:stately-concurrency:1.0.2")

                // Ktor
                implementation("io.ktor:ktor-client-core:1.3.2")
                implementation("io.ktor:ktor-client-json:1.3.2")
                implementation("io.ktor:ktor-client-serialization:1.3.2")
                implementation("io.ktor:ktor-client-gson:1.3.2")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.5")

                // Koin
                implementation("org.koin:koin-core:$commonKoinVersion")

                // SqlDelight
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation("com.russhwolf:multiplatform-settings-test:0.6")
                implementation(
                    "org.jetbrains.kotlin:kotlin-test-common:$kotlinVersion"
                )
                implementation(
                    "org.jetbrains.kotlin:kotlin-test-annotations-common:" +
                            kotlinVersion
                )
                implementation("org.koin:koin-test:$commonKoinVersion")
                implementation("co.touchlab:karmok-library:$karmokVersion")
                implementation(
                    "org.jetbrains.kotlinx:kotlinx-coroutines-test:$nativeCoroutinesVersion"
                )
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)

            dependencies {
                implementation(kotlin("stdlib", "1.3.72"))

                // Android Deps

                // Ktor
                implementation("io.ktor:ktor-client-okhttp:1.3.2")
                implementation("io.ktor:ktor-client-json-jvm:1.3.2")
                implementation("io.ktor:ktor-client-core-jvm:1.3.2")
                implementation("io.ktor:ktor-client-serialization-jvm:1.3.2")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5")

                // SqlDelight
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }

        val androidTest by getting {
            dependencies {
                implementation("androidx.test.ext:junit:$androidxTextExtVersion")
                implementation("androidx.test:rules:$androidxTestVersion")
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)

            dependencies {
                // iOS Deps

                // Ktor
                implementation("io.ktor:ktor-client-ios:1.3.2")
                implementation("io.ktor:ktor-client-core-native:1.3.2")
                implementation("io.ktor:ktor-client-json-native:1.3.2")
                implementation("io.ktor:ktor-client-serialization-native:1.3.2")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$nativeCoroutinesVersion") {
                    version {
                        strictly(nativeCoroutinesVersion)
                    }
                }

                // SqlDelight
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }

    }

    cocoapodsext {
        summary = "Common library for the KaMP starter kit"
        homepage = "https://github.com/touchlab/KaMPStarter"
        framework {
            isStatic = false
        }
    }

}

sqldelight {
    database("BokuNoHeroAcademiaMultiDb") {
        packageName = "com.corrado4eyes.bokunoheroacademiamultiplatform.shared.db"
    }
}