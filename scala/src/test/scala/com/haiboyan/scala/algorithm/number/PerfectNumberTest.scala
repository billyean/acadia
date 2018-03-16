package com.haiboyan.scala.algorithm.number

import org.scalatest.{FunSuite, Matchers}
class PerfectNumberTest extends FunSuite with Matchers {
  test("28 is a perfect number") {
    assert(PerfectNumber.isPerfect(28))
  }

  test("24 is not a perfect number") {
    assert(!PerfectNumber.isPerfect(24))
  }
}
