package com.haiboyan.scala.algorithm.math

import org.scalatest.{FunSuite, Matchers}

class BitUtilitiesTest extends FunSuite with Matchers {
  test("0 is not power of 4") {
    val p4 = Set(1, -1, 4, -4, 16, -16, 64, -64, 256, -256, 1024, -1024, 4096, -4096, 16384, -16384, 65536, -65536)
    for (i <- -65536 to 65536) {
      if (p4.contains(i)) {
        if (!BitUtilities.powerOf4(i)) {
          fail(s"Expected ${i} is power of 4")
        }
      } else {
        if (BitUtilities.powerOf4(i)) {
          fail(s"Expected ${i} is not power of 4")
        }
      }
    }
  }
}
