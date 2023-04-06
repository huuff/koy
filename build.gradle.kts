plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
    id("maven-publish")
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    id("signing")
}

group = "xyz.haff"
version = "0.8.6"

repositories {
    mavenCentral()
}

tasks.wrapper {
    gradleVersion = "7.4"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val kotestVersion = "5.4.2"
dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-json:$kotestVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("io.mockk:mockk:1.12.5")
}

tasks.withType<Test> {
    useJUnitPlatform()
    jvmArgs("--add-opens", "java.base/java.time=ALL-UNNAMED")
    finalizedBy(tasks.koverHtmlReport)
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                packaging = "jar"
                name.set(project.name)
                description.set("Random assortment of Kotlin utilities and extensions.")

                url.set("https://github.com/huuff/koy")
                scm {
                    connection.set("scm:git:git://github.com/huuff/koy.git")
                    developerConnection.set("scm:git:git@github.com:huuff/koy.git")
                    url.set("https://github.com/huuff/koy/tree/master")
                }

                licenses {
                    license {
                        name.set("WTFPL - Do What The Fuck You Want To Public License")
                        url.set("http://www.wtfpl.net")
                    }
                }

                developers {
                    developer {
                        name.set("Francisco Sánchez")
                        email.set("haf@protonmail.ch")
                        organizationUrl.set("https://github.com/huuff")
                    }
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}


nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(properties["sonatype.user"] as String)
            password.set(properties["sonatype.password"] as String)
        }
    }
}