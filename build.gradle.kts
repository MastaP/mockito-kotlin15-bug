plugins {
    kotlin("jvm") version "1.5.30"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.projectreactor:reactor-core:3.4.9")

    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation("org.mockito:mockito-inline:3.12.4")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_11.toString()
        javaParameters = true
        useFir = false // no difference with 'true'
        apiVersion = "1.4"
        languageVersion = "1.4"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
