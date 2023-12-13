package org.jguard.port

import org.jguard.client.SonarQubeClient
import org.jguard.client.SonarQubeClientRest
import org.jguard.processor.SonarProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class JguardSonarPort {

    @Bean
    fun sonarProcessor(): SonarProcessor {
        return SonarProcessor(sonarQubeClient())
    }

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder().build()
    }

    @Bean
    fun sonarQubeClient(): SonarQubeClient {
        return SonarQubeClientRest(webClient())
    }
}
