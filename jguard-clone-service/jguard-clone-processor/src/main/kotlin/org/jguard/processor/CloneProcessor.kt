package org.jguard.processor

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import org.jguard.port.function.CloneFunction
import org.jguard.port.model.RepositoryDir
import org.jguard.port.model.RepositoryInfo
import org.jguard.processor.exception.GitCloneException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class CloneProcessor : CloneFunction {

    override fun clone(repositoryInfo: RepositoryInfo) =
        extractRepositoryName(repositoryInfo)
            .runCatching {
                log.info(
                    "Cloning repository from [{}], persisting to [{}]",
                    repositoryInfo.repositoryUrl,
                    repositoryInfo.persistPath
                )
                File(repositoryInfo.persistPath + File.separator + this).apply {
                    Git.cloneRepository()
                        .setBranch(repositoryInfo.branch)
                        .setCredentialsProvider(
                            UsernamePasswordCredentialsProvider(repositoryInfo.username, repositoryInfo.password)
                        )
                        .setURI(repositoryInfo.repositoryUrl)
                        .setDirectory(this)
                        .call().use {
                            log.info("Cloned repository into [{}]", repositoryInfo.persistPath)
                        }
                }.run {
                    RepositoryDir(name, absolutePath)
                }
            }
            .getOrElse {
                log.error("There was an issue while cloning repository, please try again")
                throw GitCloneException(it.message)
            }

    private fun extractRepositoryName(repositoryInfo: RepositoryInfo) = repositoryInfo
        .repositoryUrl
        .substring(repositoryInfo.repositoryUrl.lastIndexOf("/") + 1)
        .replace(".git".toRegex(), "")

    companion object {
        val log: Logger = LoggerFactory.getLogger(CloneProcessor::class.java)
    }
}
