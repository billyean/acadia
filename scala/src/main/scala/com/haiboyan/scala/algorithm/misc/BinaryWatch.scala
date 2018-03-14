package com.haiboyan.scala.algorithm.misc

object BinaryWatch {
  def apply() = new BinaryWatch
}

class BinaryWatch {
  val tl: List[(Int, String)] = (0 until 12).flatMap(h => (0 until 60).map(m => (bits(h, m), time(h, m)))).toList

  val m: Map[Int, List[String]] = tl.groupBy(l => l._1).map(t => (t._1, t._2.map(k => k._2).toList))

  def bits(h: Int, m: Int): Int = {
    var b = 0
    var vh = h
    var vm = m

    while (vh > 0) {
      vh -= vh & -vh
      b += 1
    }
    while (vm > 0) {
      vm -= vm & -vm
      b += 1
    }
    b
  }

  def time(h: Int, m: Int): String = "%d:%02d".format(h, m)

  def getN(n: Int): List[String] = m(n)
}
