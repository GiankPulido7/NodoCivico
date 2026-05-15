# AGENTS.md - NodoCivico Android App

## Project Type
- Native Android application (single module)
- Gradle-based build with Android Gradle Plugin 8.7.0

## Build Commands

```bash
# Build debug APK
gradlew.bat assembleDebug

# Clean and rebuild
gradlew.bat clean assembleDebug

# Build release APK
gradlew.bat assembleRelease
```

On Windows, use `gradlew.bat`. On Unix, use `./gradlew`.

## Build Configuration
- Min SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Java: 1.8 (source/target compatibility)
- ViewBinding enabled (not DataBinding)

## Key Dependencies
- AndroidX Navigation Component (2.7.7)
- Retrofit 2.9.0 + OkHttp 4.12.0 for networking
- Gson for JSON parsing
- Material Design 1.11.0

## Architecture Overview
- Entry point: `MainActivity` (nav host with NavHostFragment)
- Flow: SplashFragment -> LoginFragment -> HomeFragment -> other fragments
- Uses Navigation Component for fragment management
- ViewBinding para acceder a vistas (no DataBinding)
- Repository pattern preparado para Room

## Important Notes
- SDK path in `local.properties` (user-specific, not version controlled)
- APK output: `app/build/outputs/apk/debug/app-debug.apk`
- No unit tests present
- Room Database not yet implemented (uses mock data in ReportRepository)
- Retrofit/ApiClient ready for backend connection (next deliverable)