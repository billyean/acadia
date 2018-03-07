package com.haiboyan.scala.algorithm.array

object WordSearch {
  /**
    *  Given a 2D board and a word, find if the word exists in the grid.
    *  The word can be constructed from letters of sequentially adjacent
    *  cell, where "adjacent" cells are those horizontally or vertically
    *  neighboring. The same letter cell may not be used more than once.
    *  For example,
    *  Given board =
    *  [
    *  ['A','B','C','E'],
    *  ['S','F','C','S'],
    *  ['A','D','E','E']
    *  ]
    *
    *  word = "ABCCED", -> returns true,
    *  word = "SEE", -> returns true,
    *  word = "ABCB", -> returns false.
    * @param board char array to represent 2D board
    * @param word word to be looked up
    * @return true if there is word in the board, false otherwise
    */
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    for (i <- 0 to board.length; j <- 0 to board(0).length) {
      println(s"i =  ${i},  j=  ${j}")
      if (dfs(board, word, i, j, 0))
        return true
    }

    false
  }

  def dfs(board: Array[Array[Char]], word: String, r: Int, c: Int, p: Int): Boolean = {
    if (r < 0 || r >= board.length)
      return false

    if (c < 0 || c >= board(0).length)
      return false

    if (board(r)(c) == '#' || board(r)(c) != word(p))
      return false

    if (p == word.length - 1)
      return board(r)(c) == word(p)

    if (board(r)(c) == '#')
      return false

    val k = board(r)(c)
    board(r)(c) = '#'
    val e = dfs(board, word, r - 1, c, p + 1) || dfs(board, word, r + 1, c, p + 1) || dfs(board, word, r, c - 1, p + 1) || dfs(board, word, r, c + 1, p + 1)
    board(r)(c) = k
    e
  }
}
