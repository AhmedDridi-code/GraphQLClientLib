/**
 * Copyright (c) 2022 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */

object MetaProject {
    /**
     * Artifact ID for MavenCentral or similar.
     */
    const val artifact = "angelos-project-buffer"

    /**
     * Group ID for MavenCentral or similar.
     * Can be the root package of the project.
     */
    const val group = "com.machinesTalk.GraphQLClientLib"

    /**
     * Version number of project.
     *
     * Should be based on semantic versioning as described at https://semver.org
     */
    const val version = "0.0.1" //+ "-SNAPSHOT"

    /**
     * Licence name and URL to original.
     * No abbreviation.
     */
    const val licenceName = "The MIT License"
    const val licenceUrl = "https://opensource.org/licenses/MIT"

    /**
     * Project name for MavenCentral.
     */
    const val mavenName = "KMM GraphQL Client Library™"

    /**
     * Long description for MavenCentral.
     */
    const val mavenDescription = "Library that help kmm developers to consume GraphQL apis easily."

    /**
     * Maven scm url.
     */
    const val mavenScmUrl = "https://github.com/AhmedDridi-code/GraphQLClientLib.git"

    /**
     * Maven scm connection.
     */
    const val mavenScmConnection = "scm:git:git://github.com/AhmedDridi-code/GraphQLClientLib.git"

    /**
     * Maven scm developer connection.
     */
    const val mavenScmDeveloperConnection = "scm:git:git://github.com/AhmedDridi-code/GraphQLClientLib.git"

    /**
     * MavenCentral snapshot repository.
     */
    const val mavenSnapshotRepo = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

    /**
     * MavenCentral release repository.
     */
    const val mavenReleaseRepo = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"

    /**
     * Issue management.
     */
    const val issueManagement = "https://github.com/AhmedDridi-code/GraphQLClientLib/issues"

    /**
     * Project native repository.
     */
    const val homeRepo = "https://github.com/AhmedDridi-code/GraphQLClientLib"

    /**
     * Project wide Kotlin version.
     */
    const val kotlinVersion = "1.7.10" // "1.6.21"
    const val kotlinLibrary = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"

    /**
     * Using the Dokka library of said version.
     */
    const val dokkaVersion = "1.7.0" // "1.6.21"
    const val dokkaLibrary = "org.jetbrains.dokka:dokka-gradle-plugin:${dokkaVersion}"

    /**
     * Using the Kover library of said version.
     */
    const val koverVersion = "0.5.0"
    const val koverLibrary = "org.jetbrains.kotlinx:kover:${koverVersion}"

    const val coverallsVersion = "1.2.14"
    const val coverallsLibrary = "com.github.nbaztec.coveralls-jacoco::${coverallsVersion}"
}

object MetaDevelopers {
    const val devID = "ahmeddridi"
    const val devName = "Ahmed Dridi"
    const val devEmail = "ahmed.dridi@tek-up.de"

    const val devOrg = "MachinesTalk™"
    const val devOrgUrl = "https://www.machinestalk.com"
}