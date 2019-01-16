/* This file is a part of the gradle-local-properties project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/gradle-local-properties
 */
import java.util.Properties

println("+--------------------------------+")
println("| Juuz's gradle-local-properties |")
println("+--------------------------------+")

val fileName = "private.properties"
val localConfig = File(fileName)

if (localConfig.exists()) {
    println(":$fileName found, loading...")
    val config = Properties()
    config.load(localConfig.inputStream())
    config.forEach { key, value ->
        extra[key.toString()] = value
    }
} else {
    println(":$fileName not found, skipping...")
}
