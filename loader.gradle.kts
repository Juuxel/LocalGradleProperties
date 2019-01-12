/* This file is a part of the LocalGradleProperties project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/LocalGradleProperties
 */
import groovy.util.ConfigSlurper

println(": Juuz's gradle.local.properties :")

val localConfig = File("gradle.local.properties")

if (localConfig.exists()) {
    println(":gradle.local.properties found, loading...")
    val config = ConfigSlurper().parse(localConfig.readText())
    config.forEach { key, value ->
        project.ext[key.toString()] = value
    }
} else {
    println(":gradle.local.properties not found, skipping...")
}
