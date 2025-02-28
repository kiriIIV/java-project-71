plugins {
    java
    id ("com.github.ben-manes.versions") version "0.52.0"
    application
    checkstyle
    jacoco
}


group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("info.picocli:picocli:4.7.6")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

application {
    mainClass.set("hexlet.code.App")
}