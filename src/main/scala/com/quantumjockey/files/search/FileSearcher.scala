package com.quantumjockey.files.search

import com.quantumjockey.paths.PathWrapper
import com.quantumjockey.paths.filters.FilterWrapper
import java.io.File
import scala.collection._

object FileSearcher {

  // Public Methods (Searcher)

  def findAllFilesInDirectoryTree(selectedDirectory: File): Seq[File] = findFiles(selectedDirectory) ++ (
    for (directory <- findDirectories(selectedDirectory)) yield {
      findAllFilesInDirectoryTree(directory)
    }).flatten

  def findAllFilesInDirectoryTreeByExt(selectedDirectory: File, filteredExtensions: FilterWrapper): Seq[File] = findFilesByExt(selectedDirectory, filteredExtensions) ++ (
    for (directory <- findDirectories(selectedDirectory)) yield {
      findAllFilesInDirectoryTreeByExt(directory, filteredExtensions)
    }).flatten

  def findDirectories(selectedDirectory: File): Seq[File] = for (item <- selectedDirectory.listFiles.filter(_.isDirectory)) yield item

  def findFiles(selectedDirectory: File): Seq[File] = for (item <- selectedDirectory.listFiles.filter(_.isFile)) yield item

  def findFilesByExt(selectedDirectory: File, filteredExtensions: FilterWrapper): Seq[File] = for (item <- selectedDirectory.listFiles(filteredExtensions.getFilter).filter(_.isFile)) yield item

  // Public Methods (PathWrapper object versions)

  def getAllFilesInDirectoryTree(selectedDirectory: File): Array[PathWrapper] = (
    for (item <- findAllFilesInDirectoryTree(selectedDirectory)) yield {
      new PathWrapper(item.getPath)
    })(breakOut)

  def getAllFilesInDirectoryTreeWithExt(selectedDirectory: File, filteredExtensions: FilterWrapper): Array[PathWrapper] = (
    for (item <- findAllFilesInDirectoryTreeByExt(selectedDirectory, filteredExtensions)) yield {
      new PathWrapper(item.getPath)
    })(breakOut)

}
