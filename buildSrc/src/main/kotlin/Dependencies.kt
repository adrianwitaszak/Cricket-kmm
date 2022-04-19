object Gradle {
    const val agpVersion = "7.0.2"
    private const val shadowVersion = "7.1.2"
    const val gradle = "com.android.tools.build:gradle:$agpVersion"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.kotlinVersion}"
    const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${SqlDelight.version}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.kotlinVersion}"
    const val shadow = "gradle.plugin.com.github.johnrengelman:shadow:$shadowVersion"
}

object Kotlin {
    const val kotlinVersion = "1.6.10"
    const val coroutinesVersion = "1.6.1"
    private const val kermitLoggerVersion = "1.0.0"
    private const val serializationJsonVersion = "1.3.2"

    const val stdlib =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val serialization =
        "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
    const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationJsonVersion"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val kermitLogger = "co.touchlab:kermit:$kermitLoggerVersion"
}

object Apollo {
    private const val version = "3.2.2"
    const val apollo = "com.apollographql.apollo3:apollo-runtime:$version"
}

object Koin {
    const val version = "3.2.0-beta-1"
    const val core = "io.insert-koin:koin-core:$version"
    const val android = "io.insert-koin:koin-android:$version"
    const val compose = "io.insert-koin:koin-androidx-compose:$version"
    const val workManager = "io.insert-koin:koin-androidx-workmanager:$version"
    const val ktor = "io.insert-koin:koin-ktor:$version"
    const val logger = "io.insert-koin:koin-logger-slf4j:$version"
    const val test = "io.insert-koin:koin-test:$version"
}

object Ktor {
     const val version = "2.0.0"
    private const val logbackVersion = "1.2.11"
    private const val bCryptVersion = "0.9.0"
    private const val mongoVersion = "4.5.1"

    object Client {
        const val clientCore = "io.ktor:ktor-client-core:$version"
        const val clientOkHttp = "io.ktor:ktor-client-okhttp:$version"
        const val clientJs = "io.ktor:ktor-client-js:$version"
        const val clientIOS = "io.ktor:ktor-client-ios:$version"
    }

    object Server {
        const val core = "io.ktor:ktor-server-core-jvm:$version"
        const val netty = "io.ktor:ktor-server-netty-jvm:$version"
        const val json = "io.ktor:ktor-serialization-kotlinx-json-jvm:$version"
        const val callLogging = "io.ktor:ktor-server-call-logging:$version"
        const val contentNegotiation = "io.ktor:ktor-server-content-negotiation-jvm:$version"
        const val auth = "io.ktor:ktor-server-auth-jvm:$version"
        const val jwt = "io.ktor:ktor-server-auth-jwt-jvm:$version"
        const val logback = "ch.qos.logback:logback-classic:$logbackVersion"
    }

    const val bCrypt = "at.favre.lib:bcrypt:$bCryptVersion"
    const val kMongo = "org.litote.kmongo:kmongo:$mongoVersion"
    const val kMongoCoroutines = "org.litote.kmongo:kmongo-coroutine:$mongoVersion"
}

object Backend {
    private const val logbackVersion = "1.2.10"
    private const val kGraphQLVersion = "0.17.14"
    private const val kMongoVersion = "4.5.1"
    private const val bcryptVersion = "0.9.0"
    private const val hikari = "4.0.3"
    const val logback = "ch.qos.logback:logback-classic:$logbackVersion"
    const val kMongo = "org.litote.kmongo:kmongo:$kMongoVersion"
    const val kMongoCoroutine = "org.litote.kmongo:kmongo-coroutine:$kMongoVersion"
    const val kGraphQL = "com.apurebase:kgraphql:$kGraphQLVersion"
    const val kGraphQLKtor = "com.apurebase:kgraphql-ktor:$kGraphQLVersion"
    const val bCrypt = "at.favre.lib:bcrypt:$bcryptVersion"
}

object SqlDelight {
    const val version = "1.5.3"
    const val runtime = "com.squareup.sqldelight:runtime:$version"
    const val coroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:$version"
    const val androidDriver = "com.squareup.sqldelight:android-driver:$version"
    const val nativeDriver = "com.squareup.sqldelight:native-driver:$version"
    const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:$version"
    const val sqliteJs = "com.squareup.sqldelight:sqljs-driver:$version"
}

object Android {
    const val coreVersion = "1.7.0"
    const val appCompatVersion = "1.4.0"
    const val materialVersion = "1.4.0"
    const val pagingVersion = "3.0.1"
    const val lifecycleVersion = "2.4.1"
    const val workManagerVersion = "2.7.1"
    const val dataStoreVersion = "1.0.0"
    const val accompanistVersion = "0.22.0-rc"
    const val coilVersion = "1.4.0"
    const val timberVersion = "4.7.1"

    const val appcompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val coreKtx = "androidx.core:core-ktx:$coreVersion"
    const val material = "com.google.android.material:material:$materialVersion"

    // Lifecycle
    const val lifecycle =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    const val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion"

    // Helpers
    const val coil = "io.coil-kt:coil-compose:$coilVersion"
    const val paging = "androidx.paging:paging-common-ktx:$pagingVersion"
    const val accompanistInsets =
        "com.google.accompanist:accompanist-insets:$accompanistVersion"
    const val accompanistPager =
        "com.google.accompanist:accompanist-pager:$accompanistVersion"
    const val accompanistPagerIndicators =
        "com.google.accompanist:accompanist-pager-indicators:$accompanistVersion"
    const val accompanistPlaceholder =
        "com.google.accompanist:accompanist-placeholder-material:$accompanistVersion"
    const val accompanistSwipeRefresh =
        "com.google.accompanist:accompanist-swiperefresh:$accompanistVersion"
    const val accompanistNavigationAnimation =
        "com.google.accompanist:accompanist-navigation-animation:$accompanistVersion"
    const val accompanistPermissions =
        "com.google.accompanist:accompanist-permissions:$accompanistVersion"
    const val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"
    const val timber = "com.jakewharton.timber:timber:$timberVersion"
}

object Compose {
    const val jetbrainsComposeVersion = "1.0.1"
    const val composeVersion = "1.2.0-alpha05"
    private const val composeToolingVersion = "1.1.1"
    private const val composeRuntimeVersion = "1.2.0-alpha01"
    private const val composeConstrainLayoutVersion = "1.0.0-rc02"
    private const val material3 = "1.0.0-alpha07"
    private const val navigation = "2.4.0-rc01"
    private const val activityCompose = "1.3.1"
    private const val pagingCompose = "1.0.0-alpha14"

    const val composeCompiler = "androidx.compose.compiler:compiler:$composeVersion"
    const val composeRuntime = "androidx.compose.runtime:runtime:$composeRuntimeVersion"
    const val composeConstrainLayout =
        "androidx.constraintlayout:constraintlayout-compose:$composeConstrainLayoutVersion"
    const val composeUi = "androidx.compose.ui:ui:$composeVersion"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:$composeVersion"
    const val composeMaterial = "androidx.compose.material:material:$composeVersion"
    const val composeMaterialIcons =
        "androidx.compose.material:material-icons-extended:$composeVersion"
    const val composeUiUtil = "androidx.compose.ui:ui-util:$composeVersion"
    const val composePreview =
        "androidx.compose.ui:ui-tooling-preview:$composeToolingVersion"
    const val composeTooling =
        "androidx.compose.ui:ui-tooling-preview:$composeToolingVersion"
    const val composeToolingDebug =
        "androidx.compose.ui:ui-tooling:$composeToolingVersion"
    const val composeFoundation =
        "androidx.compose.foundation:foundation:$composeVersion"
    const val composeFoundationLayout =
        "androidx.compose.foundation:foundation-layout:$composeVersion"
    const val composeAnimation =
        "androidx.compose.animation:animation:$composeVersion"
    const val composeAnimationCore =
        "androidx.compose.animation:animation-core:$composeVersion"
    const val composeMaterial3 =
        "androidx.compose.material3:material3:$material3"
    const val composeNavigation =
        "androidx.navigation:navigation-compose:$navigation"
    const val composeActivity =
        "androidx.activity:activity-compose:$activityCompose"
    const val composePaging = "androidx.paging:paging-compose:$pagingCompose"
}

object Kobweb {
    private const val version = "0.9.11"
    const val api = "com.varabyte.kobwebx:kobweb-api:$version"
    const val core = "com.varabyte.kobwebx:kobweb-core:$version"
    const val silk = "com.varabyte.kobwebx:kobweb-silk:$version"
    const val silkIcons = "com.varabyte.kobwebx:kobweb-silk-icons-fa:$version"
    const val markdown = "com.varabyte.kobwebx:kobweb-markdown:$version"
}

object TestDependencies {
    const val test_core = "1.4.0"
    const val arch_core = "2.1.0"
    const val espresso_core = "3.4.0"
    const val turbine = "0.6.0"
    const val kotest = "4.6.1"
    const val XTruth = "1.4.0"
    const val GoogleTruth = "1.0.1"
    const val junit5 = "5.7.2"
    const val mockkVersion = "1.12.3"
    const val mockito = "4.0.0"
    const val rules = "1.4.0"
    const val junit4Version = "4.13.1"
    const val junit4KtxVersion = "1.1.3"

    const val ktorTest = "io.ktor:ktor-server-tests:${Ktor.version}"
    const val kotlinTest = ("org.jetbrains.kotlin:kotlin-test:${Kotlin.kotlinVersion}")
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Kotlin.coroutinesVersion}"
    const val composeAndroidTest = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val composeDebugTest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
    const val testRunner = "androidx.test:runner:1.4.0"

    // Core library
    const val junit4Ktx = "androidx.test.ext:junit:$junit4KtxVersion"
    const val junit4 = "junit:junit:$junit4Version"
    const val testCore = "androidx.test:core:$test_core"
    const val archCore = "androidx.arch.core:core-testing:$arch_core"
    const val truth = "com.google.truth:truth:$GoogleTruth"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val koinTestJUnit4 = "io.insert-koin:koin-test-junit4:${Koin.version}"

    // Work
    const val work = "androidx.work:work-testing:${Android.workManagerVersion}"
}
