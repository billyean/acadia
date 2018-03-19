package com.haiboyan.scala.algorithm.array

object Intersection {
  def intersectNum(matrix : List[List[Int]]) :Int = {
    val noDup : List[Int] = matrix.map(_.distinct.toList).flatMap(_.toList)
    noDup.groupBy(i => i).filter(_._2.size == 3).size
  }
}
