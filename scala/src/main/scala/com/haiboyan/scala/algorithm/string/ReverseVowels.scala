package com.haiboyan.scala.algorithm.string

object ReverseVowels extends App {
//  def reverse(string: String): String = {
//    val vowels_reg = "[aeiouAEIOU]".r
//
//    val vowels_reversed = vowels_reg.findAllIn(string).toList.reverse
//
//  }

  val vowels_reg = "[aeiouAEIOU]".r
  val novowels_reg = "([^aeiouAEIOU])+".r
  novowels_reg.findAllIn("AMy name is Tristan").toList.reverse.foreach(println)
}
