import org.gradle.api.JavaVersion

object AppConfig {
    const val module = "buddy-kmm"
    const val compileSdk = 32
    const val applicationId = Group.main
    const val minSdk = 21
    const val targetSdk = compileSdk
    val versionCode = Releases.android.toInt()
    const val versionName = Releases.android
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val javaVersion = "11"
    val javaVersionName = JavaVersion.VERSION_1_8
}

object Releases {
    const val backend = "0.0.1"
    const val site = "0.0.1"
    const val android = "0.0.1"
    const val iOS = "0.0.1"
}

object Group {
     const val main = "com.adwi.buddy"

    const val backend = main + ".backend"
    const val site = main + ".site"
    const val android = main + ".android"
}

