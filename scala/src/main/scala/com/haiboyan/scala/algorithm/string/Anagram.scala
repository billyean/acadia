package com.haiboyan.scala.algorithm.string

import scala.collection.mutable.Map

object Anagram {
  def isAnagram(s1: String, s2: String) = {
    if (s1.length != s2.length) {
      false
    }
    var cm1 = Map[Char, Int]().withDefaultValue(0)
    var cm2 = Map[Char, Int]().withDefaultValue(0)

    for (i <- 0 until s1.length) {
      cm1(s1.charAt(i)) = cm1(s1.charAt(i)) + 1
      cm2(s2.charAt(i)) = cm2(s2.charAt(i)) + 1
    }

    cm1 == cm2
  }
}
