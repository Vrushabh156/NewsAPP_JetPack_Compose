import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.parcelize)
}

// Case 1:
//If you only need the API key (one or more than one) and want to delay loading until it's actually needed,
// then this snippet with lazy initialization is more appropriate.

val apiKey: String by lazy {
    val properties = Properties()
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { stream ->
            properties.load(stream)
        }
    }
    properties.getProperty("NEWS_API_KEY", "")
}

//Case 2:
//If you need to work with multiple properties, then this snippet might be more convenient.

//Example:

//apiKey=your_actual_api_key_here
//databaseUrl=https://your.database.url
//featureFlag=true

/*
val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { load(it) }
    }
}
*/

android {
    namespace = "com.vrushabh.newsapp_jetpack_compose"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.vrushabh.newsapp_jetpack_compose"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        //Case 1:
        buildConfigField("String", "API_KEY", "\"$apiKey\"")

        //Case 2:
        /* buildConfigField(
            "String",
            "API_KEY",
            "\"${localProperties.getProperty("NEWS_API_KEY") ?: ""}\""
        )  */
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
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

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Splash API
    implementation(libs.core.splashscreen)

    // Compose Navigation
    implementation(libs.navigation.compose)

    // Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    // Coil for image loading
    implementation(libs.coil.compose)

    // Datastore Preferences
    implementation(libs.datastore.preferences)

    // Compose Foundation
    implementation(libs.compose.foundation)

    // Accompanist System UI Controller
    implementation(libs.accompanist.systemuicontroller)

    // Paging 3
    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)

    // Room Database
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)


}
