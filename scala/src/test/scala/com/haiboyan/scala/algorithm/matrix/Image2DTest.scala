package com.haiboyan.scala.algorithm.matrix

import org.scalatest.{FunSuite, Matchers}

class Image2DTest extends FunSuite with Matchers{
  test("Rotate 3*3 matrix") {
    val matrix = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))

    val image = new Image2D(matrix).rotate()

    assert(image.images == List(List(7, 4, 1), List(8, 5, 2), List(9, 6, 3)))
  }

  test("Rotate 4*4 matrix") {
    val matrix = List(List(5, 1, 9, 11), List(2, 4, 8, 10), List(13, 3, 6, 7), List(15, 14, 12, 16))

    val image = new Image2D(matrix).rotate()

    assert(image.images == List(List(15, 13, 2, 5), List(14, 3, 4, 1), List(12, 6, 8, 9), List(16, 7, 10, 11)))
  }
}
