plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

kotlin {
    jvmToolchain(JavaVersion.VERSION_11.toString().toInt())
}

android {
    namespace = "com.joaoferreira.techchallenge"

    defaultConfig {
        applicationId = "com.joaoferreira.techchallenge"
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(rootProject.libs.compose.ui)
    implementation(rootProject.libs.compose.material3)
    implementation(rootProject.libs.activity.compose)

    implementation(rootProject.libs.hilt.android)
    ksp(rootProject.libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(rootProject.libs.hilt.android)
    androidTestImplementation(rootProject.libs.hilt.android.testing)
    kspAndroidTest(rootProject.libs.hilt.compiler)
}