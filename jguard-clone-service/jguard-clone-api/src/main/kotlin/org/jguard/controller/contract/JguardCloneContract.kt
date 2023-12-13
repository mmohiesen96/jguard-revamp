package org.jguard.controller.contract

import org.jguard.port.model.RepositoryDir
import org.jguard.port.model.RepositoryInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("api/v1/jguard")
interface JguardCloneContract {
    @PostMapping("clone")
    fun cloneService(@RequestBody repositoryInfo: RepositoryInfo): ResponseEntity<RepositoryDir>
}
