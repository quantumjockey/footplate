package com.quantumjockey.files.search

import java.io.File
import com.quantumjockey.paths.PathOperator
import com.quantumjockey.paths.filters.FilterWrapper
import com.quantumjockey.system.SystemAttributes
import org.scalatest.FunSpec

class FileSearcherSpec extends FunSpec {

  // Setup

  val specPath: String = SystemAttributes.UserHome + SystemAttributes.FileSeparator + "Documents" + SystemAttributes.FileSeparator + "Spec"
  val basePath: String = specPath + SystemAttributes.FileSeparator + "filesystemhelper"
  val subPath: String = basePath + SystemAttributes.FileSeparator + "branch"
  val subSubPath: String = subPath + SystemAttributes.FileSeparator + "moar_branch"

  val baseAddendum: String = basePath + SystemAttributes.FileSeparator
  val subAddendum: String = subPath + SystemAttributes.FileSeparator
  val subSubAddendum: String = subSubPath + SystemAttributes.FileSeparator

  val filePathsTxt: Seq[String] = Seq[String](
    baseAddendum + "file1.txt",
    subAddendum + "file4.txt",
    subAddendum + "file6.txt"
  )

  val filePathsStf: Seq[String] = Seq[String](
    baseAddendum + "file2.stf",
    baseAddendum + "file3.stf",
    subSubAddendum + "file5.stf",
    subAddendum + "file7.stf"
  )

  val filePathsAll: Seq[String] = filePathsStf ++ filePathsTxt

  for (item: String <- filePathsAll) PathOperator.createFileWithDirectories(item)

  // Requirements

  describe("A file searching object") {

    describe("'find files' action") {

      it("should return a sequence containing all files within the specified directory, regardless of type") {
        val expectedFiles: Seq[File] = Seq[File](
          new File(baseAddendum + "file1.txt"),
          new File(baseAddendum + "file2.stf"),
          new File(baseAddendum + "file3.stf")
        )
        val resultantFiles: Seq[File] = FileSearcher.findFiles(new File(basePath))
        assert(expectedFiles.sorted == resultantFiles.sorted)
      }

    }

    describe("'find directories' action") {

      it("should return a sequence containing all directories within the specified directory") {
        val expectedFiles: Seq[File] = Seq[File](
          new File(subPath)
        )
        val resultantFiles: Seq[File] = FileSearcher.findDirectories(new File(basePath))
        assert(expectedFiles.sorted == resultantFiles.sorted)
      }

    }

    describe("'find all files in directory tree' action") {

      it("should return a sequence of paths to all files within the specified directory as well as subdirectories") {
        val expectedFiles: Seq[File] = for (item <- filePathsAll) yield new File(item)
        val resultantFiles: Seq[File] = FileSearcher.findAllFilesInDirectoryTree(new File(basePath))
        assert(expectedFiles.sorted == resultantFiles.sorted)
      }

    }

    describe("'find all files with extension' action") {

      it("should return a sequence of paths to all files (with specified extensions) within the specified directory") {
        val expectedFiles: Seq[File] = Seq[File](
          new File(baseAddendum + "file2.stf"),
          new File(baseAddendum + "file3.stf")
        )
        val resultantFiles: Seq[File] = FileSearcher.findFilesByExt(new File(basePath), new FilterWrapper(Array[String](".stf", "stf")))
        assert(expectedFiles.sorted == resultantFiles.sorted)
      }

    }

    describe("'find all files with extension in directory tree' action") {

      it("should return a sequence of paths to all files (with specified extensions) within the specified directory as well as subdirectories") {
        val expectedFiles: Seq[File] = for (item <- filePathsStf) yield new File(item)
        val resultantFiles: Seq[File] = FileSearcher.findAllFilesInDirectoryTreeByExt(new File(basePath), new FilterWrapper(Array[String](".stf", "stf")))
        assert(expectedFiles.sorted == resultantFiles.sorted)
      }

    }

  }

}
