plugins {
    id("java")
    application
    checkstyle
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")

    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.compileJava {
    options.compilerArgs = options.compilerArgs.also { it.add("-Aproject=${project.group}/${project.name}") };
}

tasks.test {
    useJUnitPlatform()
}