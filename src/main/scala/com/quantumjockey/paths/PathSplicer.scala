package com.quantumjockey.paths

import com.quantumjockey.system.SystemAttributes

object PathSplicer {

  // Fields

  val windowsSeparator = "/"

  // Public Methods

  def getPathComponents(path: String): Array[String] = if (SystemAttributes.OSName.contains("Windows")) {
    path.replace(SystemAttributes.FileSeparator, this.windowsSeparator).split(this.windowsSeparator)
  } else {
    path.split(SystemAttributes.FileSeparator)
  }

}
