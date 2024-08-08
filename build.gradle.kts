plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.claire"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	// JDBC lab dependencies
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("com.h2database:h2")
	// JPA lab dependencies
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// services
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	//redis
	implementation("com.bucket4j:bucket4j-core:8.9.0")
	implementation("com.bucket4j:bucket4j-redis:8.9.0")
	implementation("io.lettuce:lettuce-core:6.3.1.RELEASE")
	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
