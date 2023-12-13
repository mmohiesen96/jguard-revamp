package org.jguard.controller.contract

import org.jguard.domain.model.request.SonarRequest
import org.jguard.domain.model.issues.SonarIssuesResponse
import org.jguard.domain.model.response.SQCreateProjectResponse
import org.jguard.domain.model.response.SQProjectFinishedResponse
import org.jguard.domain.model.response.SQTokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/jguard/sonar/v1/")
interface JguardSonarContract {

    @GetMapping("issues/retrieve")
    fun retrieveIssues(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<SonarIssuesResponse>

    @GetMapping("project/finished")
    fun isProjectFinished(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<SQProjectFinishedResponse>

    @PostMapping("project/create")
    fun createProject(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<SQCreateProjectResponse>

    @PostMapping("token/generate")
    fun generateToken(
        @RequestBody sonarRequest: SonarRequest,
    ): ResponseEntity<SQTokenResponse>

}