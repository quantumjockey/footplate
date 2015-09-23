package com.quantumjockey.paths

import com.quantumjockey.paths.test.SamplePath
import org.scalatest.FunSpec

class PathSplicerSpec extends FunSpec {

  // Requirements

  describe("Path 'splicer' object") {

    describe("get path components action") {

      it("should split path into an array of strings containing directories/filename") {
        assert(SamplePath.components sameElements PathSplicer.getPathComponents(SamplePath.path))
      }

    }

  }

}
