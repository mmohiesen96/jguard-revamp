package org.jguard.controller.api

import org.jguard.controller.contract.JguardSonarContract
import org.jguard.domain.function.SonarFunction
import org.jguard.domain.model.issues.SonarIssuesResponse
import org.jguard.domain.model.request.SonarRequest
import org.jguard.domain.model.response.SQCreateProjectResponse
import org.jguard.domain.model.response.SQProjectFinishedResponse
import org.jguard.domain.model.response.SQTokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class JguardSonarApiController(private val sonarFunction: SonarFunction) : JguardSonarContract {

    override fun retrieveIssues(
        sonarRequest: SonarRequest
    ): ResponseEntity<SonarIssuesResponse> =
        ResponseEntity.ok(sonarFunction.retrieveIssues(sonarRequest))

    override fun isProjectFinished(sonarRequest: SonarRequest): ResponseEntity<SQProjectFinishedResponse> =
        ResponseEntity.ok(SQProjectFinishedResponse(sonarFunction.isProjectFinished(sonarRequest)))

    override fun createProject(sonarRequest: SonarRequest): ResponseEntity<SQCreateProjectResponse> =
        ResponseEntity.ok(sonarFunction.createProject(sonarRequest))


    override fun generateToken(sonarRequest: SonarRequest): ResponseEntity<SQTokenResponse> =
        ResponseEntity.ok(sonarFunction.generateToken(sonarRequest))

}