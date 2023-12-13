package org.jguard.processor

import org.jguard.domain.function.ParseApplicationYmlFunction
import org.jguard.domain.function.ParseProjectStructureFunction
import org.jguard.domain.model.ApplicationYml
import org.jguard.processor.util.FilesProvider
import org.slf4j.LoggerFactory
import org.yaml.snakeyaml.Yaml
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

class ParseApplicationYmlProcessor(
    private val parseProjectStructureFunction: ParseProjectStructureFunction
) : ParseApplicationYmlFunction {
    override fun parse(persistPath: String, rootName: String) = try {
        FilesProvider(parseProjectStructureFunction.parse(persistPath, rootName).projectDirectories)
            .provide("application.(yaml|yml)$").apply {
                if (isEmpty())
                    throw FileNotFoundException()
            }.first().run {
                FileInputStream(this).use { input ->
                    ApplicationYml(Yaml().load(input))
                }
            }
    } catch (e: FileNotFoundException) {
        logger.error("Something went wrong, maybe application yaml doesn't exist")
        ApplicationYml(mapOf())
    } catch (e: IOException) {
        logger.error("Error parsing the yaml file with path")
        ApplicationYml(mapOf())
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ParseApplicationYmlProcessor::class.java)
    }
}
