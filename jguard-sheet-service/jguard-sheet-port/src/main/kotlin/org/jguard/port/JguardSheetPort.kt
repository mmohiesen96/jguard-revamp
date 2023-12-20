package org.jguard.port

import SheetProcessor
import org.jguard.port.function.SheetFunction
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader

@Configuration
class JguardSheetPort(private val resourceLoader: ResourceLoader) {

    @Bean
    fun sheetProcessor(): SheetFunction = SheetProcessor(resourceLoader)


}