package com.haiboyan.scala.algorithm.array

import org.scalatest.{FunSuite, Matchers}

class RemoveDuplicatesTest extends FunSuite with Matchers {
  test("Remove Duplicate in [1,1,2] should return 2") {
    assert(RemoveDuplicates.removeDuplicates(Array(1,1,2)) === 2)
  }

  test("Remove Duplicate in [1,1,1,2,2,3] should return 3") {
    assert(RemoveDuplicates.removeDuplicates(Array(1,1,1,2,2,3)) === 3)
  }

  test("Remove Duplicate At Most Twice in [1,1,2] should return 3") {
    assert(RemoveDuplicates.removeDuplicatesAtMostTwice(Array(1,1,2)) === 3)
  }

  test("Remove Duplicate At Most Twice in [1,1,1,2,2,3] should return 5") {
    assert(RemoveDuplicates.removeDuplicatesAtMostTwice(Array(1,1,1,2,2,3)) === 5)
  }
}
