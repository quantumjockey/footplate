package com.quantumjockey.paths

import java.nio.file.Path
import com.quantumjockey.files.io.{DirectoryOperator, FileOperator}
import com.quantumjockey.system.SystemAttributes

object PathOperator {

  // Public Methods

  def createFileWithDirectories(outputPath: String): Unit = {

    val components: Array[String] = PathSplicer.getPathComponents(outputPath)

    for ((item, i) <- components.view.zipWithIndex) {

      val partialPath = components.dropRight(components.length - (i + 1)).mkString(SystemAttributes.FileSeparator)

      if (item != components.last) {
        DirectoryOperator.create(partialPath)
      } else {
        FileOperator.create(partialPath)
      }

    }

  }

  def createFileWithDirectories(outputPath: Path): Unit = createFileWithDirectories(outputPath.toString)

}
