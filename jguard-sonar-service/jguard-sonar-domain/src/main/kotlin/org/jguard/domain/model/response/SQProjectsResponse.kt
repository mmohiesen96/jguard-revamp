package org.jguard.domain.model.response

import org.jguard.domain.model.sonar.qube.data.Component
import org.jguard.domain.model.sonar.qube.data.Paging

data class SQProjectsResponse(
    val paging: Paging,
    val components: List<Component>
)