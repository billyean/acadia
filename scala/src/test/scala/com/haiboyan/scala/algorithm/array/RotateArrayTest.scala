package com.haiboyan.scala.algorithm.array

import org.scalatest.{FunSuite, Matchers}

class RotateArrayTest extends FunSuite with Matchers {
  test("Rotate Left [], 0 expected []") {
    assert(RotateArray.rotateLeft(Array(), 0) === Array())
  }

  test("Rotate Left [1, 2, 3, 4, 5, 6, 7], 0 expected [1, 2, 3, 4, 5, 6, 7]") {
    assert(RotateArray.rotateLeft(Array(1, 2, 3, 4, 5, 6, 7), 0) === Array(1, 2, 3, 4, 5, 6, 7))
  }

  test("Rotate Left [1, 2, 3, 4, 5, 6, 7], 1 expected [2, 3, 4, 5, 6, 7, 1]") {
    assert(RotateArray.rotateLeft(Array(1, 2, 3, 4, 5, 6, 7), 1) === Array(2, 3, 4, 5, 6, 7, 1))
  }

  test("Rotate Right [1, 2, 3, 4, 5, 6, 7], 1 expected [2, 3, 4, 5, 6, 7, 1]") {
    assert(RotateArray.rotateRight(Array(1, 2, 3, 4, 5, 6, 7), 1) === Array(7, 1, 2, 3, 4, 5, 6))
  }
}
