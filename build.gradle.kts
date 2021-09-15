// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.1")
    val hilt_version by extra("2.38.1")

    val composeActivityVersion by extra("1.3.0-beta02")
    val ktxCoreVersion by extra("1.5.0")
    val lifeCycleVersion by extra("2.3.1")
    val materialVersion by extra("1.3.0")
    val composeNavigationVersion by extra("2.4.0-alpha03")
    val hiltComposeNavVersion by extra("1.0.0-alpha03")
    val hiltVersion by extra("2.37")
    val hiltAndroidXVersion by extra("1.0.0-alpha03")
    val roomVersion by extra("2.3.0")
    val dataStoreVersion by extra("1.0.0-beta02")
    val coroutinesVersion by extra("1.5.0-native-mt")
    val hiltComposeVersion by extra("1.0.0-alpha03")
    val hiltCompilerVersion by extra("1.0.0")
    val kotlinVersion by extra("1.5.10")
    val moshiVersion by extra("1.11.0")
    val systemUIControllerVersion by extra("0.12.0")
    val expressoVersion by extra("3.3.0")
    val kotlinSerializationVersion by extra("1.2.1")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}