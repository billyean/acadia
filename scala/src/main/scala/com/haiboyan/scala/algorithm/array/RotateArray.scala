package com.haiboyan.scala.algorithm.array

object RotateArray extends App{
  def rotateLeft(array : Array[Int], k: Int) : Array[Int] = {
    if (array.length == 0) {
      array
    } else {
      val m = k % array.length
      (array.slice(0, m).reverse ++ array.slice(m, array.length).reverse).reverse
    }
  }

  def rotateRight(array : Array[Int], k: Int) = rotateLeft(array, array.length - k)
}
