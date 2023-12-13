package org.jguard.processor

import org.apache.maven.model.io.xpp3.MavenXpp3Reader
import org.codehaus.plexus.util.xml.pull.XmlPullParserException
import org.jguard.domain.function.ParsePomFunction
import org.jguard.domain.function.ParseProjectStructureFunction
import org.jguard.domain.model.PomFile
import org.jguard.processor.exception.RequiredFileNotFoundException
import org.jguard.processor.util.FilesProvider
import org.slf4j.LoggerFactory
import java.io.FileReader
import java.io.IOException

class ParsePomProcessor(
    private val parseProjectStructureFunction: ParseProjectStructureFunction
) : ParsePomFunction {
    override fun parse(persistPath: String, rootName: String) = try {
        FilesProvider(parseProjectStructureFunction.parse(persistPath, rootName).projectDirectories)
            .provide("pom.xml").apply {
                if (isEmpty())
                    throw RequiredFileNotFoundException()
            }.map {
                MavenXpp3Reader().read(FileReader(it)).run {
                    buildMap<String, String> {
                        "groupId" to groupId
                        "artifactId" to artifactId
                        "version" to version
                    }
                }.run { PomFile(this) }
            }
    } catch (e: RequiredFileNotFoundException) {
        logger.error("No pom file was found")
        listOf()
    } catch (e: IOException) {
        logger.error("Error parsing file pom.xml")
        listOf()
    } catch (e: XmlPullParserException) {
        logger.error("Error parsing file pom.xml")
        listOf()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ParsePomProcessor::class.java)
    }


}