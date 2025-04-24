plugins {
    id("java")
    application
    checkstyle
    jacoco
    id("org.sonarqube") version "6.0.1.5171"
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sonar {
    properties {
        property("sonar.projectKey", "rom-kavyrshin_java-project-71")
        property("sonar.organization", "rom-kavyrshin")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.3")

    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.compileJava {
    options.compilerArgs = options.compilerArgs.also { it.add("-Aproject=${project.group}/${project.name}") };
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
    }
}