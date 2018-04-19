package com.haiboyan.scala.algorithm.array

object Duplicate {
  def remove(nums: List[Int]) : List[Int] = {
    val noDup = nums.distinct
    noDup ++ nums.drop(noDup.length)
  }
}
