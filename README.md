
# Android Starter Template (Jetpack Compose + Hilt + Retrofit + Room)

This repository is a **template** for creating modern Android apps with:

- **Jetpack Compose** UI (Material 3)
- **Navigation Compose** for screen navigation
- **Hilt (Dagger)** for dependency injection
- **Retrofit + OkHttp** for networking
- **Room** for local database
- **Gradle Version Catalog (TOML)** for centralized dependency management
- **Compose BOM** for aligned Compose versions

---

## ✅ Features Included
- **Login Screen**
- **Dashboard** with:
  - Navigation Drawer (hamburger menu)
  - Floating Action Button (FAB)
  - Tab Navigation (Home, Reports, Profile)
- **MVVM Architecture** with ViewModel separation
- **Repository pattern** for data handling
- **Preconfigured DI modules** for Network, Database, and Repository layers

---

## 🛠 Tech Stack
- **Android Gradle Plugin:** 8.13.x
- **Kotlin:** 2.2.x
- **Gradle:** 9.2.x
- **Jetpack Compose BOM:** 2025.x
- **Hilt:** 2.57.x
- **Retrofit:** 3.x
- **OkHttp:** 4.x
- **Room:** 2.8.x

---

## 📂 Project Structure

app/
├─ build.gradle.kts
├─ src/main/
│   ├─ AndroidManifest.xml
│   ├─ res/values/themes.xml
│   └─ kotlin/PACKAGE_PATH/
│       ├─ App.kt
│       ├─ MainActivity.kt
│       ├─ AppNavGraph.kt
│       ├─ di/ (Hilt modules)
│       ├─ data/ (network, db, repository)
│       └─ ui/ (login, dashboard)
gradle/libs.versions.toml

