package com.haiboyan.scala.algorithm.array

class Pattern {
  def print(n: Int): List[List[Int]] = {
    var pattern = List[List[Int]]()

    if (n < 1) {
      pattern
    }
    pattern ::= List[Int](1)
    for (i <- 1 until n) {
      val p = pattern.take(i - 1)
      p.zipWithIndex
    }

    pattern
  }
}
