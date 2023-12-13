package org.jguard.controller.api

import org.jguard.controller.contract.JguardCloneContract
import org.jguard.port.function.CloneFunction
import org.jguard.port.model.RepositoryDir
import org.jguard.port.model.RepositoryInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class JguardCloneApiController(private val cloneFunction: CloneFunction) : JguardCloneContract {
    override fun cloneService(repositoryInfo: RepositoryInfo): ResponseEntity<RepositoryDir> =
        ResponseEntity.ok(cloneFunction.clone(repositoryInfo))
}
