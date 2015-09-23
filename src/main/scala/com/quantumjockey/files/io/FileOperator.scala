package com.quantumjockey.files.io

import java.io.IOException
import java.nio.file.{Path, Files, Paths}
import com.quantumjockey.files.io.base.IOOperatorBase

object FileOperator extends IOOperatorBase {

  // Public Methods

  def create(outputPath: Path): Unit = {
    try {
      if (!Files.exists(outputPath)) Files.createFile(outputPath)
    } catch {
      case ex: IOException => ex.printStackTrace()
    }
  }

  def create(outputPath: String): Unit = create(Paths.get(outputPath))

}
