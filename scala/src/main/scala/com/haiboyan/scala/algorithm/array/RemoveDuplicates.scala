package com.haiboyan.scala.algorithm.array

object RemoveDuplicates {
  def removeDuplicates(nums: Array[Int]): Int = nums.distinct.length

  def removeDuplicatesAtMostTwice(nums: Array[Int]): Int = {
    val s = nums.groupBy(t => t).map(t => if (t._2.length >= 2) 2 else 1).sum
    s
  }
}
