import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.util.*

plugins {
    `maven-publish`
    signing
}

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val secretPropsFile = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

fun getExtraString(name: String) = ext[name]?.toString()

publishing {
    // Configure maven central repository
    repositories {
        maven {

            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }

    }


    // Configure all publications
    publications.withType<MavenPublication> {

        // Stub javadoc.jar artifact
        artifact(javadocJar.get())


        // Provide artifacts information requited by Maven Central
        pom {
            version = MetaProject.version
            groupId = MetaProject.group
            name.set(MetaProject.artifact)
            description.set(MetaProject.mavenDescription)
            url.set(MetaProject.homeRepo)

            licenses {
                license {
                    name.set(MetaProject.licenceName)
                    url.set(MetaProject.licenceUrl)
                    distribution.set("repo")
                }
            }
            developers {
                developer {
                    id.set(MetaDevelopers.devID)
                    name.set(MetaDevelopers.devName)
                    email.set(MetaDevelopers.devEmail)
                }
                organization {
                    name.set(MetaDevelopers.devOrg)
                    url.set(MetaDevelopers.devOrgUrl)
                }
            }
            scm {
                url.set(MetaProject.mavenScmUrl)
                connection.set(MetaProject.mavenScmConnection)
                developerConnection.set(MetaProject.mavenScmDeveloperConnection)
            }
            issueManagement {
                url.set(MetaProject.issueManagement)
            }

        }
    }
}

// Signing artifacts. Signing.* extra properties values will be used

signing {
    sign(publishing.publications)
}