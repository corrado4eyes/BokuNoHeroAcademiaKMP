plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        applicationId = "com.corrado4eyes.bokunoheroacademiamultiplatform"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        val localIp: String by project

        getByName("debug") {
//            buildConfigField("String", "BASE_URL", "\"http://192.168.1.78:8080\"")
            buildConfigField("String", "BASE_URL", "\"http://$localIp:8080\"")
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // TODO: Change release BASE_URL
            buildConfigField("String", "BASE_URL", "\"http://$localIp:8080\"")
        }
    }

    buildFeatures {
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    val kotlinVersion: String by project
    val gsonVersion: String by project
    val retrofitVersion: String  by project
    val coroutinesVersion: String  by project
    val koinVersion: String  by project
    val recyclerVersion: String  by project
    val coilVersion: String  by project
    val ktorVersion: String  by project
    val sqlDelightVersion: String by project

    implementation(kotlin("stdlib-jdk7", kotlinVersion))
    implementation(project(":shared"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Android Specific
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.recyclerview:recyclerview:$recyclerVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$gsonVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Koin
    implementation("org.koin:koin-androidx-scope:$koinVersion")
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")
    implementation("org.koin:koin-android:$koinVersion")
    implementation("org.koin:koin-core:$koinVersion")

    // Ktor
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")

    // Coil
    implementation("io.coil-kt:coil:$coilVersion")

    // SqlDelight
    implementation("com.squareup.sqldelight:runtime-jvm:$sqlDelightVersion}")
    implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")

    // Tests
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}