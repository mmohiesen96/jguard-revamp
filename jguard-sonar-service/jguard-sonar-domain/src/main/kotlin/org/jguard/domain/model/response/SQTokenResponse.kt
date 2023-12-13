package org.jguard.domain.model.response

data class SQTokenResponse(
    val login: String,
    val name: String,
    val token: String
)
