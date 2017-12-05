package com.haiboyan.scala.algorithm.permutation

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class PermuteTest extends FunSuite with Matchers {
  test("Permute h") {
    assert(Permute.permutation("h") == List("h"))
  }

  test("Permute hi") {
    assert(Permute.permutation("hi") == List("hi", "ih"))
  }
}
