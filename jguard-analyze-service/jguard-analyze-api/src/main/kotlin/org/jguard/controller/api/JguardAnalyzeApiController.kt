package org.jguard.controller.api

import org.jguard.controller.contract.JguardAnalyzeContract
import org.jguard.controller.model.AnalyzeProjectTreeReq
import org.jguard.domain.function.ParseApplicationYmlFunction
import org.jguard.domain.function.ParsePomFunction
import org.jguard.domain.function.ParseProjectStructureFunction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class JguardAnalyzeApiController(
    private val parseProjectStructureFunction: ParseProjectStructureFunction,
    private val parseApplicationYmlFunction: ParseApplicationYmlFunction,
    private val parsePomFunction: ParsePomFunction
) : JguardAnalyzeContract {

    override fun analyzePomFile(analyzeProjectTreeReq: AnalyzeProjectTreeReq) =
        ResponseEntity.ok(parsePomFunction.parse(analyzeProjectTreeReq.persistPath, analyzeProjectTreeReq.rootName))

    override fun analyzeApplicationYml(analyzeProjectTreeReq: AnalyzeProjectTreeReq) =
        ResponseEntity.ok(
            parseApplicationYmlFunction.parse(
                analyzeProjectTreeReq.persistPath,
                analyzeProjectTreeReq.rootName
            )
        )
}