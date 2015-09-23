package com.quantumjockey.paths

import com.quantumjockey.paths.test.SamplePath
import org.scalatest.FunSpec

class PathBuilderSpec extends FunSpec {

  // Requirements

  describe("Path 'builder' object") {

    describe("create path from components action") {

      it("should generate a path from an an array of strings containing directories/filename in that path") {
        assert(SamplePath.path == PathBuilder.createPathFromComponents(SamplePath.components))
      }

    }

  }

}
