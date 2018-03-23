package com.haiboyan.scala.algorithm.math

object BitUtilities {
  def powerOf4(n: Int): Boolean = {
    n match {
      case 1 | -1=> true
      case n if n < 4 && n > -4 => false
      case t => if (n % 4 == 0)  powerOf4(n / 4) else false
    }
  }
}
