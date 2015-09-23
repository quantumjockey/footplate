package com.quantumjockey.files.encoding

import java.nio.ByteBuffer
import java.nio.charset.Charset

object EncodingCatalogue {

  // Public Methods

  def getEncodedStrings(stringBytes: Array[Byte]): Array[EncodedString] = this.getEncodedStrings(new String(stringBytes))

  def getEncodedStrings(stringInput: String): Array[EncodedString] = for (encodingTag <- this.getAvailableEncodings) yield {
    val buffer: ByteBuffer = Charset.forName(encodingTag).encode(stringInput)
    new EncodedString(encodingTag, new String(buffer.array()))
  }

  // Private Methods

  private def getAvailableEncodings: Array[String] = Array[String](
    "IBM437",
    "IBM775",
    "IBM850",
    "IBM852",
    "IBM855",
    "IBM857",
    "IBM862",
    "IBM866",
    "ISO-8859-1",
    "ISO-8859-2",
    "ISO-8859-4",
    "ISO-8859-5",
    "ISO-8859-7",
    "ISO-8859-9",
    "ISO-8859-13",
    "ISO-8859-15",
    "KOI8-R",
    "KOI8-U",
    "US-ASCII",
    "UTF-8",
    "UTF-16",
    "UTF-16BE",
    "UTF-16LE",
    "UTF-32",
    "UTF-32BE",
    "UTF-32LE",
    "x-UTF-32BE-BOM",
    "x-UTF-32LE-BOM",
    "windows-1250",
    "windows-1251",
    "windows-1252",
    "windows-1253",
    "windows-1254",
    "windows-1257",
    "x-IBM737",
    "x-IBM874",
    "x-IBM874",
    "x-UTF-16LE-BOM"
  )

}
