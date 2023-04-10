import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
    id("io.spring.dependency-management")
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(17)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}


allprojects {
    group = "ru.anomind"
    val guava: String by project

    repositories {
        mavenLocal()
        mavenCentral()
    }

    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        dependencies {
            dependency("com.google.guava:guava:$guava")
        }
    }
    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
        }
    }

}