/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.4.1/samples
 */

import java.io.ByteArrayOutputStream

val dataFolder = "_data"
val originalFileName = "vocabolangelo.ttl"
val inferredFileName = "vocabolangelo-inferred.xml"
val mergedFileName = "vocabolangelo-merged.ttl"

fun filePath(fileName: String) = dataFolder + File.separator + fileName

val originalFilePath = filePath(originalFileName)
val inferredFilePath = filePath(inferredFileName)
val mergedFilePath = filePath(mergedFileName)

tasks.register<Exec>("test") {
    commandLine("turtle", "--validate", originalFilePath)
}

tasks.register("infer") {
    doLast{
<<<<<<< HEAD
        try {
            val inferredText: String = ByteArrayOutputStream().use { outputStream ->
                exec{
                    commandLine("pellet", "extract", originalFilePath)
                    standardOutput = outputStream
                }
                outputStream.toString()
            }
            File(inferredFilePath).writeText(inferredText)

            val mergedText: String = ByteArrayOutputStream().use { outputStream ->
                exec{
                    commandLine("riot", "--output=TURTLE", originalFilePath, inferredFilePath)
                    standardOutput = outputStream
                }
                outputStream.toString()
            }
            File(mergedFilePath).writeText(mergedText)
        } finally {
            File(inferredFilePath).delete()
        }
=======
        val outputStream = ByteArrayOutputStream()
        exec{
            commandLine("pellet", "extract", originalFilePath)
            standardOutput = outputStream
        }
        File(inferredFilePath).writeText(outputStream.toString())
>>>>>>> 8330a32 (added infer task logic)
    }
}
