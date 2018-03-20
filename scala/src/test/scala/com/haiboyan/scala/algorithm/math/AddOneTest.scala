package com.haiboyan.scala.algorithm.math

import org.scalatest.{FunSuite, Matchers}

class AddOneTest extends FunSuite with Matchers {
  test("Add one 1 bit") {
    assert(AddOne.add_one(Array(1, 2, 3, 4, 5)) === Array(1, 2, 3, 4, 6))
  }

  test("Add one 2 bit") {
    assert(AddOne.add_one(Array(1, 2, 3, 9, 9)) === Array(1, 2, 4, 0, 0))
  }

  test("Add one all bits") {
    assert(AddOne.add_one(Array(9, 9, 9, 9, 9)) === Array(1, 0, 0, 0, 0, 0))
  }
}
