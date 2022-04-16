import org.gradle.api.JavaVersion

object AppConfig {
    const val compileSdk = 32
    const val applicationId = "com.adwi.cricket"
    const val minSdk = 21
    const val targetSdk = compileSdk
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val javaVersion = "11"
    val javaVersionName = JavaVersion.VERSION_1_8
}

