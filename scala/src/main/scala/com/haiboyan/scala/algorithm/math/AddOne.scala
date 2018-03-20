package com.haiboyan.scala.algorithm.math

object AddOne {
  def add_one(values : Array[Int]): Array[Int] = {
    val r_add_one = values match {
      case Array(9) => Array[Int](1, 0)
      case Array(0) => Array(1)
      case Array(1) => Array(2)
      case Array(2) => Array(3)
      case Array(3) => Array(4)
      case Array(4) => Array(5)
      case Array(5) => Array(6)
      case Array(6) => Array(7)
      case Array(7) => Array(8)
      case Array(8) => Array(9)
      case htail => {
        val l = add_one(htail.tail)
        val h = Array(htail.head)
        if (l.length == htail.length - 1) h ++ l else  add_one(h) ++ l.tail
      }
    }
    r_add_one
  }
}
