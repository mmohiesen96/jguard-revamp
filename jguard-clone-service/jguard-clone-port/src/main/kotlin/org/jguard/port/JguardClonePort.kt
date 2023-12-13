package org.jguard.port

import org.jguard.processor.CloneProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JguardClonePort {
    @Bean
    fun cloneProcessor() = CloneProcessor()
}
