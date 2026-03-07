plugins {
    application
    id("org.sonarqube") version "7.2.3.7755"
    checkstyle
    jacoco
    id("com.github.ben-manes.versions") version "0.51.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("hexlet.code.App")
}

sonar {
    properties {
        property("sonar.projectKey", "Vitaliy-Golikov_java-project-71")
        property("sonar.organization", "vitaliy-golikov")
    }
}

tasks.register("run-dist") {
    dependsOn("installDist")
    doLast {
        println("Application installed to: build/install/app/")
        println("Run: .\\build\\install\\app\\bin\\app.bat")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(true)
    }
}

checkstyle {
    toolVersion = "10.12.1"
    config = resources.text.fromFile(File(projectDir.parentFile, "config/checkstyle/checkstyle.xml"))
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(false)
        html.required.set(true)
    }
}