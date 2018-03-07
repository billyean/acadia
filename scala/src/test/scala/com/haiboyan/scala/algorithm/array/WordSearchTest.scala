package com.haiboyan.scala.algorithm.array

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class WordSearchTest extends FunSuite with Matchers {
  test("WordSearch multiple true") {
    var board = Array(Array('A', 'B', 'C', 'E'), Array('S', 'F', 'C', 'S'), Array('A', 'D', 'E', 'E'))
    val word = "ABCCED"
    assert(WordSearch.exist(board, word))
  }

  test("WordSearch single exact false") {
    var board = Array(Array('a'))
    val word = "b"
    assert(WordSearch.exist(board, word) == false)
  }

  test("WordSearch single exact true") {
    var board = Array(Array('a'))
    val word = "a"
    assert(WordSearch.exist(board, word))
  }

  test("WordSearch  multiple exact false") {
    var board = Array(Array('a', 'b'), Array('c', 'd'))
    val word = "abcd"
    assert(WordSearch.exist(board, word) == false)
  }
}
