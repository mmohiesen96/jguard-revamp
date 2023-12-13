package org.jguard.processor

import org.jguard.domain.function.ParseProjectStructureFunction
import org.jguard.domain.model.ProjectTree
import org.jguard.processor.exception.EmptyFilesException
import org.slf4j.LoggerFactory
import java.io.File

class ParseProjectStructureProcessor : ParseProjectStructureFunction {
    override fun parse(persistPath: String, rootName: String): ProjectTree =
        ProjectTree(mutableListOf()).run {
            logger.info("Analyzing repository file tree from [{}]", persistPath)
            scanDirectory(File(persistPath + File.separator + rootName), this)
            this
        }

    private fun scanDirectory(directory: File, projectTree: ProjectTree) =
        directory.listFiles().apply {
            if (isNullOrEmpty())
                throw EmptyFilesException("Repository Have no files")
        }.run {
            logger.info("Finished analyzing project tree")
            projectTree.projectDirectories.addAll(listOf(*this!!))
        }

    companion object {
        private val logger = LoggerFactory.getLogger(ParseProjectStructureProcessor::class.java)
    }
}
