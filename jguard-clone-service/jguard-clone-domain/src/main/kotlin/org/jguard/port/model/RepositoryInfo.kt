package org.jguard.port.model

data class RepositoryInfo(
    val repositoryUrl: String,
    val persistPath: String,
    val branch: String,
    val username: String,
    val password: String
)
