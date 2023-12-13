package org.jguard.processor.util

import java.io.File
import java.util.*

class FilesProvider(private val projectFilesList: List<File>) {
    private val foundFilesList: MutableList<File> = ArrayList()
    fun provide(fileName: String, absolutePath: Boolean): List<File> {
        foundFilesList.clear()
        return searchInFileSystemTree(fileName, projectFilesList, absolutePath)
    }

    fun provide(fileName: String): List<File> {
        foundFilesList.clear()
        return searchInFileSystemTree(fileName, projectFilesList, false)
    }

    private fun searchInFileSystemTree(
        fileName: String,
        projectFilesList: List<File>,
        absolutePath: Boolean
    ): List<File> {
        for (file in projectFilesList) {
            if (file.isDirectory()) {
                searchInFileSystemTree(fileName, Arrays.asList(*Objects.requireNonNull(file.listFiles())), absolutePath)
            } else {
                if (!absolutePath) {
                    if (file.getName().matches(fileName.toRegex())) {
                        foundFilesList.add(file)
                    } else {
                        if (file.absolutePath.matches(fileName.toRegex())) {
                            foundFilesList.add(file)
                        }
                    }
                }
            }
        }
        return foundFilesList
    }
}