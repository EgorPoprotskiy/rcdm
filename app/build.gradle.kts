plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")

}

android {
    namespace = "com.egorpoprotskiy.rcdm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.egorpoprotskiy.rcdm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
//    kotlin {
//        jvmToolchain(17)
//    }
}

dependencies {
    val room_version = "2.5.2"
    val nav_version = "2.7.2"
    val cor_version = "1.6.4"
    val lifecycle_version = "2.6.2"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    //для фрагментов
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")

    //Корутины
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$cor_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$cor_version")

    // Room libraries
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // дополнительно - Поддержка расширений Kotlin и сопрограмм для Room
    implementation("androidx.room:room-ktx:$room_version")
    // Для использования обработки символов Kotlin (KSP)
//    ksp("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
}