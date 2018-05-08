package com.haiboyan.scala.algorithm.string


object Isomorphic extends App {
  def isomorphic (s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) {
      false
    }

    var map1 = Map[Char, Char]()
    var map2 = Map[Char, Char]()

    s1.toCharArray.zip(s2.toCharArray).foreach(t => {
      map1(t._1) =
    })

    true
  }

}
