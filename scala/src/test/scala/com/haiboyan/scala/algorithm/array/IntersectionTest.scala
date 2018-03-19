package com.haiboyan.scala.algorithm.array

import org.scalatest.{FunSuite, Matchers}

class IntersectionTest extends FunSuite with Matchers{
  test("No intersection") {
    val matrix = List(
      List(1, 2, 3),
      List(2, 4, 5),
      List(9, 3, 10)
    )

    assert(Intersection.intersectNum(matrix) === 0)
  }

  test("Only 1 intersection") {
    val matrix = List(
      List(1, 2, 3),
      List(3, 4, 5),
      List(9, 3, 10)
    )

    assert(Intersection.intersectNum(matrix) === 1)
  }
}
