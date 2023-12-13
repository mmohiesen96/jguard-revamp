package org.jguard.domain.function

import org.jguard.domain.model.ApplicationYml

fun interface ParseApplicationYmlFunction {
    fun parse(persistPath: String, rootName: String): ApplicationYml
}