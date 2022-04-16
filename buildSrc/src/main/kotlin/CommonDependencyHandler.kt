import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addAndroidTestDependencies() {
    androidTestImplementation(TestDependencies.composeAndroidTest)
    debugImplementation(TestDependencies.composeDebugTest)
    addCommonTestDependencies()
}

fun DependencyHandler.addTestDependencies() {
    addCommonTestDependencies()
}

private fun DependencyHandler.addCommonTestDependencies() {
    implementation(TestDependencies.testRunner)
    implementation(TestDependencies.junit4Ktx)
    implementation(TestDependencies.junit4)
    implementation(TestDependencies.truth)
    implementation(TestDependencies.mockk)
    implementation(TestDependencies.coroutinesTest)
}

@Suppress("detekt.UnusedPrivateMember")
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? =
    add("kaptTest", dependencyNotation)

@Suppress("detekt.UnusedPrivateMember")
fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? =
    add("kaptAndroidTest", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

@Suppress("unchecked_cast", "nothing_to_inline", "detekt.UnsafeCast")
private inline fun <T> uncheckedCast(obj: Any?): T = obj as T