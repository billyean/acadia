package com.haiboyan.scala.algorithm.matrix

case class Image2D(images : List[List[Int]]) {
  def rotate(): Image2D = {
    val r = images.length
    if (r == 0) {
      return this
    }
    val c = images(0).length
    if (c == 0) {
      return this
    }

    var rotated = List[List[Int]]()
    for (i <- 0 until c) {
      val n = images.map(_(i)).reverse
      rotated ++= List(n)
    }

    return Image2D(rotated)
  }
}
