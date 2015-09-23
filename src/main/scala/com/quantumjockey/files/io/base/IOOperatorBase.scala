package com.quantumjockey.files.io.base

import java.nio.file.Path

abstract class IOOperatorBase {

  // public methods

  def create(outputPath: Path): Unit

  def create(outputPath: String): Unit

}
