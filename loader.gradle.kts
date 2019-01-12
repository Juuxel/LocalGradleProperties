/* This file is a part of the gradle-local-properties project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/gradle-local-properties
 */
import groovy.util.ConfigSlurper
import org.gradle.api.plugins.ExtraPropertiesExtension

println("+--------------------------------+")
println("| Juuz's gradle-local-properties |")
println("+--------------------------------+")

val fileName = "private.properties"
val localConfig = File(fileName)

if (localConfig.exists()) {
    println(":$fileName found, loading...")
    val config = ConfigSlurper().parse(localConfig.readText())
    config.forEach { key, value ->
        (extensions.getByName("ext") as ExtraPropertiesExtension)[key.toString()] = value
    }
} else {
    println(":$fileName not found, skipping...")
}
