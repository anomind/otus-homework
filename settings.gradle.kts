rootProject.name = "otus-homework"
include ("hw01-gradle")
include("hw04-generics")

pluginManagement {
    val johnrengelmanShadow: String by settings
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings



    plugins {
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot

    }
}