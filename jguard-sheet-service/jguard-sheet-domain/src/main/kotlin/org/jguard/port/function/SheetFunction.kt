package org.jguard.port.function

import org.jguard.port.model.Sheet

interface SheetFunction {
    fun parseSheet(lang: String): Sheet
}