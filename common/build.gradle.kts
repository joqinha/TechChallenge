plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.joaoferreira.techchallenge.common"

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(rootProject.libs.androidx.core.ktx)

    implementation(rootProject.libs.hilt.android)
    ksp(rootProject.libs.hilt.compiler)

    testImplementation(rootProject.libs.junit5)
    testImplementation(rootProject.libs.test.mockk)
}