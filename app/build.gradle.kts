
plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.ksp)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "__PACKAGE_NAME__"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    applicationId = "__PACKAGE_NAME__"
    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.targetSdk.get().toInt()
    versionCode = 1
    versionName = "1.0"
  }
  @Suppress("DEPRECATION")
  dexOptions {
    javaMaxHeapSize = "4g"
  }

  buildFeatures { compose = true }

  // Compose compiler is not part of the BOM; set explicitly. [3](https://androidstudio.googleblog.com/2026/01/)
  composeOptions { kotlinCompilerExtensionVersion = "1.5.14" }
  compileOptions {
        // Sets the Java compiler target
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
  kotlinOptions { jvmTarget = "17" }
}

dependencies {
  // Compose BOM first, then Compose libs without versions. [3](https://androidstudio.googleblog.com/2026/01/)
  implementation(platform(libs.compose.bom))
  implementation(libs.bundles.compose.core)
  implementation(libs.activity.compose)
  implementation(libs.navigation.compose)
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.material)
  implementation(libs.compose.icons.extended)  

  // Hilt + KSP compiler
  implementation(libs.bundles.hilt.stack)
  ksp(libs.hilt.compiler)

  // Retrofit + OkHttp stack
  implementation(libs.bundles.network.stack)
  implementation(libs.moshi.kotlin) 

  // Room + KSP compiler + coroutines
  implementation(libs.bundles.room.stack)
  ksp(libs.room.compiler)
  implementation(libs.coroutines.android)
}
