package org.jguard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JguardAnalyzeStarter

fun main(vararg args: String) {
    runApplication<JguardAnalyzeStarter>(*args)
}