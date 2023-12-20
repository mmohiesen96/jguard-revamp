package org.jguard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JguardSheetStarter

fun main(vararg args: String) {
    runApplication<JguardSheetStarter>(*args)
}
