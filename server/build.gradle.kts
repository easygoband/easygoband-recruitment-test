import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ratpack.gradle.*

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.41"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.ratpack:ratpack-gradle:1.4.1")
        classpath(kotlinModule("gradle-plugin", kotlin_version))
    }
}

plugins {
    java
}

group = "test"
version = "1.0-SNAPSHOT"

apply {
    plugin<RatpackPlugin>()
    plugin("kotlin")
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))
    testCompile("junit", "junit", "4.12")
    runtime("org.apache.logging.log4j:log4j-slf4j-impl:2.6.1")
    runtime("org.apache.logging.log4j:log4j-api:2.6.1")
    runtime("org.apache.logging.log4j:log4j-core:2.6.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}