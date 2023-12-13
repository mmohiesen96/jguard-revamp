package org.jguard.domain.model.response

import com.fasterxml.jackson.annotation.JsonProperty
import org.jguard.domain.model.sonar.qube.data.Project

data class SQCreateProjectResponse(
    @JsonProperty(value = "project")
    val project: Project
)
