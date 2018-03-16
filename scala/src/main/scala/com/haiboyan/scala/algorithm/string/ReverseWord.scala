package com.haiboyan.scala.algorithm.string

object ReverseWord {

  def reverse(sentence: String) : String = {
    val prespace = "^\\s+".r.findFirstIn(sentence).getOrElse("")
    val afterspace = "\\s+$".r.findFirstIn(sentence).getOrElse("")

    val trimmed = sentence.trim
    val expr = "\\s+"
    var spaces = expr.r.findAllIn(trimmed).toList :+ ""
    val words = trimmed.split(expr).reverse

    return prespace + words.zip(spaces).map(t => t._1 + t._2).mkString("") + afterspace
  }
}
