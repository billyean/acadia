package com.haiboyan.scala.algorithm.array

object Zigzag {
  def convert(s: String, numRows: Int): String = {
    if (numRows < 2 || s.length == 0) {
      s
    } else {
      var zs = ""

      for (i <- 0 until numRows) {
        val sp1 = 2 * (numRows - i - 1)
        val sp2 = 2 * i

        var add = true
        var b = i

        while (b < s.length) {
          zs += s(b)
          (sp1, sp2, add) match {
            case (0, _, _) => b += sp2
            case (_, 0, _) => b += sp1
            case (_, _, true) => b += sp1
            case _ => b += sp1
          }
          add = !add
        }
      }
      zs
    }
  }
}
