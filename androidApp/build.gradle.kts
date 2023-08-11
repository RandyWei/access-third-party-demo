plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.chinahrt.app.shitu"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "com.chinahrt.app.shitu"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs{
        create("release"){
            keyAlias = "key0"
            keyPassword = "chinahrt00"
            storePassword = "chinahrt00"
            storeFile = file("/Users/wei/AndroidStudioProjects/shitu/android/app/keystore")
        }
    }

    buildTypes {
        getByName("release"){
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug"){
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
