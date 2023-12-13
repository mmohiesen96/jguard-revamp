package org.jguard.port.function

import org.jguard.port.model.RepositoryDir
import org.jguard.port.model.RepositoryInfo

fun interface CloneFunction {
    fun clone(repositoryInfo: RepositoryInfo): RepositoryDir
}
