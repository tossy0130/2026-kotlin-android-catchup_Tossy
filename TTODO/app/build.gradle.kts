plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Room のコンパイラを動かすために必要
    alias(libs.plugins.ksp)

    // Hilt を使うために必要
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.t_todo"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.t_todo"
        minSdk = 26
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Room 本体
    implementation(libs.androidx.room.runtime)

    // Room + Kotlin Coroutine / Flow 用
    implementation(libs.androidx.room.ktx)

    // Room のコード生成用
    ksp(libs.androidx.room.compiler)

    // Hilt 本体
    implementation(libs.hilt.android)

    // Hilt のコード生成用
    ksp(libs.hilt.android.compiler)

    // Compose 画面で hiltViewModel() を使うため
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")
}