package com.quantumjockey.paths

import com.quantumjockey.system.SystemAttributes

object PathBuilder {

  // Public Methods

  def createPathFromComponents(pathComponents: Array[String]): String = pathComponents.mkString(SystemAttributes.FileSeparator)

}
