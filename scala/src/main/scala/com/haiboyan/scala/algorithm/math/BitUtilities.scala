package com.haiboyan.scala.algorithm.math

object BitUtilities {
  def powerOf4(n: Int): Boolean = {
    n match {
      case 1 | -1=> true
      case n if n < 4 && n > -4 => false
      case t => if (n % 4 == 0)  powerOf4(n / 4) else false
    }
  }

  def findDanglingInTwos(nums: List[Int]): Int = nums.fold(0)((v1, v2) => v1 ^ v2)

  def findDanglingInThrees(nums: List[Int]): Int =
    nums.foldLeft((0, 0, 0))((b, v) => {
      var two = b._2 | (b._1 & v)
      var one = b._1 ^ v
      var three = one & two
      one = one & (~three)
      two = two & (~three)
      (one, two, three)
    })._1

  def findDanglingInFours(nums: List[Int]): Int =
    nums.foldLeft((0, 0, 0, 0))((b, v) => {
      var two = b._2 | (b._1 & v)
      var one = b._1 ^ v
      var three = one & two
      var four = three & (~one)
      one = one & (~four)
      two = two & (~four)
      three = three & (~four)
      (one, two, three, four)
    })._1
}
