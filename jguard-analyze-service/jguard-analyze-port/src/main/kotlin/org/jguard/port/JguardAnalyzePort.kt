package org.jguard.port

import org.jguard.domain.function.ParseProjectStructureFunction
import org.jguard.processor.ParseApplicationYmlProcessor
import org.jguard.processor.ParsePomProcessor
import org.jguard.processor.ParseProjectStructureProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JguardAnalyzePort {
    @Bean
    fun parseApplicationYmlProcessor(
        parseProjectStructureFunction: ParseProjectStructureFunction
    ) = ParseApplicationYmlProcessor(parseProjectStructureFunction)

    @Bean
    fun parsePomProcessor(
        parseProjectStructureFunction: ParseProjectStructureFunction
    ) = ParsePomProcessor(parseProjectStructureFunction)

    @Bean
    fun parseProjectStructureProcessor(): ParseProjectStructureFunction = ParseProjectStructureProcessor()
}
