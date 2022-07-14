import org.jetbrains.kotlin.gradle.tasks.KotlinCompile




buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-noarg:1.6.21")
	}
}

plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.6.21"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.github.DevSanso"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11



repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	//maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.apache.tika:tika-parsers-standard-package:2.4.1")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.apache.tika:tika-core:2.4.1")
	implementation("net.jthink:jaudiotagger:3.0.1")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.1")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.0.6")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework:spring-webflux")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


allOpen {
	annotation("javax.persistence.Entity") // @Entity가 붙은 클래스에 한해서만 all open 플러그인을 적용
}

noArg {
	annotation("javax.persistence.Entity")
}