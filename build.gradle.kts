import com.android.build.gradle.BaseExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.com.android.library) apply false
}

subprojects {
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    afterEvaluate {
        plugins.withType<BasePlugin> {
            configure<BaseExtension> {
                compileSdkVersion = libs.versions.compile.sdk.version.get()

                defaultConfig {
                    minSdk = libs.versions.minimum.sdk.version.get().toInt()
                    targetSdk = libs.versions.target.sdk.version.get().toInt()
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
            }
        }
    }
}