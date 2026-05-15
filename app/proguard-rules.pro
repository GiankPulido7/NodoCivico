# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep model classes
-keep class com.nodocivico.models.** { *; }

# Keep Retrofit service interfaces
-keep,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Gson specific rules
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }