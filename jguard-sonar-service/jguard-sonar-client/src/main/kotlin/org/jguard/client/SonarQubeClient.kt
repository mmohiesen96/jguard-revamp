package org.jguard.client

import org.jguard.domain.model.response.SQCreateProjectResponse
import org.jguard.domain.model.request.SonarRequest
import org.jguard.domain.model.response.SQIssuesResponse
import org.jguard.domain.model.response.SQProjectsResponse
import org.jguard.domain.model.response.SQTokenResponse
import org.springframework.http.HttpStatusCode

interface SonarQubeClient {
    fun generateToken(sonarRequest: SonarRequest): SQTokenResponse?
    fun createProject(sonarRequest: SonarRequest): SQCreateProjectResponse?
    fun retrieveProjectResponse(sonarRequest: SonarRequest): SQProjectsResponse?
    fun retrieveIssueResponse(sonarRequest: SonarRequest): SQIssuesResponse?
}