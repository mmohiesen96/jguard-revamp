package org.jguard.domain.function

import org.jguard.domain.model.PomFile

fun interface ParsePomFunction {
    fun parse(persistPath: String, rootName: String): List<PomFile>
}