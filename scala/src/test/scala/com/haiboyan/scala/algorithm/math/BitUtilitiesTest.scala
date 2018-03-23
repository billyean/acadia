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

  test("6 appears once in [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5]") {
    assert(BitUtilities.findDanglingInTwos(List(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5)) == 6)
  }

  test("6 appears once in twos in [6]") {
    assert(BitUtilities.findDanglingInTwos(List(6)) == 6)
  }

  test("6 appears once in [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1]") {
    assert(BitUtilities.findDanglingInThrees(List(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1)) == 6)
  }

  test("6 appears once in threes in [6]") {
    assert(BitUtilities.findDanglingInThrees(List(6)) == 6)
  }

  test("6 appears once in [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1]") {
    assert(BitUtilities.findDanglingInFours(List(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1)) == 6)
  }

  test("6 appears once in fours in [6]") {
    assert(BitUtilities.findDanglingInFours(List(6)) == 6)
  }
}
