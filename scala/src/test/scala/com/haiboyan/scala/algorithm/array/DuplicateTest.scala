package com.haiboyan.scala.algorithm.array

import org.scalatest.{FunSuite, Matchers}

class DuplicateTest extends FunSuite with Matchers{
  test("remove duplicate from [1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4 , 4, 5] should return [1, 2, 3, 4, 5, 3, 4, 4, 4, 4, 4, 4, 5]") {
    assert(Duplicate.remove(List(1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4 , 4, 5)) == List(1, 2, 3, 4, 5, 3, 4, 4, 4, 4, 4, 4, 5))
  }

  test("remove duplicate from [1, 2, 3, 4, 5, 1, 2, 3] should return [1, 2, 3, 4, 5, 1, 2, 3]") {
    assert(Duplicate.remove(List(1, 2, 3, 4, 5, 1, 2, 3)) == List(1, 2, 3, 4, 5, 1, 2, 3))
  }

  test("remove duplicate from [1, 2, 3, 4, 5] should return [1, 2, 3, 4, 5]") {
    assert(Duplicate.remove(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
  }

  test("remove duplicate from [] should return []") {
    assert(Duplicate.remove(List()) == List())
  }
}
