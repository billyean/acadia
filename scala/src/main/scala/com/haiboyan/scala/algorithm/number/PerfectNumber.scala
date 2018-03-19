package com.haiboyan.scala.algorithm.number

object PerfectNumber {
  def isPerfect(num: Int): Boolean = {
    if (num < 6) {
      return false
    }
    val si = Math.sqrt(num.toDouble).toInt

    val sum = (2 to si).filter(num % _ == 0).map(i => if(num / i == i) i else (i + num / i)).sum

    return sum + 1 == num
  }
}
