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
    implementation(project(":allapps"))

    implementation(rootProject.libs.androidx.core.ktx)
    implementation(rootProject.libs.androidx.appcompat)
    implementation(rootProject.libs.material)

    implementation(rootProject.libs.compose.ui)
    implementation(rootProject.libs.compose.material3)
    implementation(rootProject.libs.activity.compose)
    implementation(rootProject.libs.lifecycle.viewmodel.compose)
    implementation(rootProject.libs.coil)

    implementation(rootProject.libs.hilt.android)
    implementation(rootProject.libs.hilt.navigation.compose)
    ksp(rootProject.libs.hilt.compiler)

    testImplementation(rootProject.libs.junit)
    androidTestImplementation(rootProject.libs.androidx.junit)
    androidTestImplementation(rootProject.libs.androidx.espresso.core)
    androidTestImplementation(rootProject.libs.hilt.android)
    androidTestImplementation(rootProject.libs.hilt.android.testing)
    kspAndroidTest(rootProject.libs.hilt.compiler)
}