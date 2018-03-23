package com.haiboyan.scala.algorithm.math

import org.scalatest.{FunSuite, Matchers}

class SortByOneTest extends FunSuite with Matchers {
  test("Sort [] with one's bits should got []") {
    assert(SortByOne.sort(List()) == List())
  }

  test("Sort [1, 2, 3, 4, 5] with one's bits should got [1, 2, 4, 3, 5]") {
    assert(SortByOne.sort(List(1, 2, 3, 4, 5)) == List(1, 2, 4, 3, 5))
  }

  test("Sort [1, -1, 2, - 2, 3, -3] with one's bits should got [1, 2, 3, -2, -3, -1]") {
    assert(SortByOne.sort(List(1, -1, 2, - 2, 3, -3)) == List(1, 2, 3, -2, -3, -1))
  }
}
