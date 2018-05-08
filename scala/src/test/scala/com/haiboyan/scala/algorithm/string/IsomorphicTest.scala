package com.haiboyan.scala.algorithm.string

import org.scalatest.{FunSuite, Matchers}

class IsomorphicTest extends FunSuite with Matchers {
  test("add and egg is isomorphic") {
    assert(Isomorphic.isomorphic("add", "egg"))
  }

  test("foo and bar is not isomorphic") {
    assert(!Isomorphic.isomorphic("foo", "bar"))
  }
}
