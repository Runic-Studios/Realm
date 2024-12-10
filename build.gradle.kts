import com.ncorti.ktfmt.gradle.tasks.*

plugins {
	kotlin("jvm") version "1.9.25"
	id("com.ncorti.ktfmt.gradle") version "0.21.0"
}

group = "com.runicrealms"
version = "3.0"

repositories {
	mavenCentral()
	maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
	// Guice Dependency
	implementation("com.google.inject:guice:7.0.0")

	// Kotlin Reflection
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Paper Dependency
	compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// Testing Dependencies
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

ktfmt {
	kotlinLangStyle()
}

tasks.register<KtfmtFormatTask>("ktfmtPrecommit") {
	source = project.fileTree(rootDir)
	include("**/*.kt")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
