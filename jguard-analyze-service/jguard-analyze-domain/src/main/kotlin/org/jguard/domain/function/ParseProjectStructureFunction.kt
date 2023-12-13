package org.jguard.domain.function

import org.jguard.domain.model.ProjectTree

fun interface ParseProjectStructureFunction {
    fun parse(persistPath: String, rootName: String): ProjectTree
}
