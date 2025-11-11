plugins {
    alias(libs.plugins.kotlin.jvm)
    id("me.champeau.jmh").version("0.7.3")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}


jmh {
    warmupIterations = 2
    iterations = 2
    fork = 2
}
