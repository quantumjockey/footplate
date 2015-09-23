package com.quantumjockey.system

object SystemAttributes {

  // Constants

  val FileSeparator: String = System.getProperty("file.separator")
  val JavaClassPath: String = System.getProperty("java.class.path")
  val JavaHome: String = System.getProperty("java.home")
  val JavaVendor: String = System.getProperty("java.vendor")
  val JavaVendorUrl: String = System.getProperty("java.vendor.url")
  val JavaVersion: String = System.getProperty("java.version")
  val LineSeparator: String = System.getProperty("line.separator")
  val OSArchitecture: String = System.getProperty("os.arch")
  val OSName: String = System.getProperty("os.name")
  val OSVersion: String = System.getProperty("os.version")
  val PathSeparator: String = System.getProperty("path.separator")
  val UserDirectory: String = System.getProperty("user.dir")
  val UserHome: String = System.getProperty("user.home")
  val UserName: String = System.getProperty("user.name")

}
