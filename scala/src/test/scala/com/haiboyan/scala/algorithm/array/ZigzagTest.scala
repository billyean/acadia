package com.haiboyan.scala.algorithm.array

import org.scalatest.{FunSuite, Matchers}

class ZigzagTest extends FunSuite with Matchers{
  test("Zigzag abc on 2 should be acb") {
    assert(Zigzag.convert("abc", 2) === "acb")
  }

  test("Zigzag abc on 3 should be acb") {
    assert(Zigzag.convert("abc", 3) === "abc")
  }
}
