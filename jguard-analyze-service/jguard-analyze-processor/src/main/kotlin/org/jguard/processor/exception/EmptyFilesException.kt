package org.jguard.processor.exception

class EmptyFilesException(repositoryHaveNoFiles: String?) : RuntimeException(repositoryHaveNoFiles)
