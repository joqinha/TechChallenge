plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.joaoferreira.techchallenge.allapps"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

}

dependencies {
    implementation(rootProject.libs.androidx.core.ktx)

    implementation(rootProject.libs.compose.ui)
    implementation(rootProject.libs.compose.material3)
    implementation(rootProject.libs.lifecycle.viewmodel.compose)

    implementation(rootProject.libs.hilt.android)
    ksp(rootProject.libs.hilt.compiler)

    implementation(rootProject.libs.retrofit2)
    implementation(rootProject.libs.retrofit2.moshi)
    implementation(rootProject.libs.retrofit2.gson)
    implementation(rootProject.libs.okhttp3)
    implementation(rootProject.libs.okhttp3.interceptor)
    implementation(rootProject.libs.moshi)

    implementation(rootProject.libs.room.runtime)
    implementation(rootProject.libs.room.ktx)
    ksp(rootProject.libs.room.compiler)
}
