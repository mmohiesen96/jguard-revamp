package org.jguard.controller.contract

import org.jguard.controller.model.AnalyzeProjectTreeReq
import org.jguard.domain.model.ApplicationYml
import org.jguard.domain.model.PomFile
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("api/v1/jguard")
interface JguardAnalyzeContract {
    @GetMapping("pom")
    fun analyzePomFile(@RequestBody analyzeProjectTreeReq: AnalyzeProjectTreeReq): ResponseEntity<List<PomFile>>

    @GetMapping("yaml")
    fun analyzeApplicationYml(@RequestBody analyzeProjectTreeReq: AnalyzeProjectTreeReq): ResponseEntity<ApplicationYml>
}
