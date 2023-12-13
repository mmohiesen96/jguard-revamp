package org.jguard.domain.model.request

data class SonarRequest(
    val projectName: String,
    val token: String
)
