package com.haiboyan.scala.algorithm.math

object SortByOne {
  def _one(n: Int): Int = {
    n match {
      case 0 => 0
      case t => 1 + _one(n - (n & -n))
    }
  }

  def sort(nums: List[Int]): List[Int] = nums.sortBy(_one(_))
}
