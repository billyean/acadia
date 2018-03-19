package com.haiboyan.scala.algorithm.string

object RemoveLetters {
  def remove(s: String): String = s.toCharArray.distinct.sorted.mkString("")
}
