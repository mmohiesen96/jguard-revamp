package org.jguard.client

import org.jguard.domain.model.request.SonarRequest
import org.jguard.domain.model.response.SQCreateProjectResponse
import org.jguard.domain.model.response.SQIssuesResponse
import org.jguard.domain.model.response.SQProjectsResponse
import org.jguard.domain.model.response.SQTokenResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.reactive.function.client.WebClient


class SonarQubeClientRest(private val webClient: WebClient) : SonarQubeClient {

    @Value("\${config.sonarQube.url}")
    lateinit var sonarQubeUrl: String

    override fun generateToken(sonarRequest: SonarRequest): SQTokenResponse? =
        webClient
            .post()
            .uri("${sonarQubeUrl}/api/user_tokens/generate?name=${sonarRequest.projectName}")
            .header("Authorization", "Bearer ${sonarRequest.token}")
            .retrieve()
            .bodyToMono(SQTokenResponse::class.java)
            .block()

    override fun createProject(sonarRequest: SonarRequest): SQCreateProjectResponse? = webClient
        .post()
        .uri("${sonarQubeUrl}/api/projects/create?key=${sonarRequest.projectName}&name=${sonarRequest.projectName}&project=${sonarRequest.projectName}")
        .header("Authorization", "Bearer ${sonarRequest.token}")
        .retrieve()
        .bodyToMono(
            SQCreateProjectResponse::
            class.java
        )
        .block()


    override fun retrieveProjectResponse(sonarRequest: SonarRequest): SQProjectsResponse? = webClient
        .get()
        .uri("${sonarQubeUrl}/api/projects/search?projects=${sonarRequest.projectName}")
        .header("Authorization", "Bearer ${sonarRequest.token}")
        .retrieve()
        .bodyToMono(SQProjectsResponse::class.java)
        .block()

    override fun retrieveIssueResponse(sonarRequest: SonarRequest): SQIssuesResponse? = webClient
        .get()
        .uri("${sonarQubeUrl}/api/issues/search?componentKeys=${sonarRequest.projectName}")
        .header("Authorization", "Bearer ${sonarRequest.token}")
        .retrieve()
        .bodyToMono(SQIssuesResponse::class.java)
        .block()


}