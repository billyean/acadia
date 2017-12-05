package com.haiboyan.scala.algorithm.permutation

object Permute {
  /**
    * Given a string, returns a sequence of strings that are lexicographic permutations of the input string:
    * @param x
    * @return
    */
  def permutation(x: String): Seq[String] = {
    def innerPermutation(seq: Seq[String], string: String): Seq[String] = {
      (string.length, seq) match {
        case (0, _) => seq
        case (1, Seq()) => Seq(string)
        case _ => {
          val next = innerPermutation (seq, string.substring(1))
          val head = string.substring (0, 1)
          next.flatMap (s => (0 until s.length + 1)
            .map (i => s.substring (0, i).concat (head).concat (s.substring (i)))).distinct
        }
      }
    }

    innerPermutation(Seq(), x)
  }

  /**
    * Produces an iterator over all possible combinations of length n by given a sequence of elements. A combination is
    * a way of selecting elements from the collection so that every element is selected once, and the order of elements
    * does not matter.
    * For example, given a collection Seq(1, 4, 9, 16), combinations of length 2 are Seq(1, 4), Seq(1, 9), Seq(1, 16),
    * Seq(4, 9), Seq(4, 16), and Seq(9, 16)
    * @param n
    * @param xs
    * @return
    */
  def combinations(n: Int, xs: Seq[Int]): Iterator[Seq[Int]] = {
    def innerCombinations(result: Seq[Seq[Int]], n: Int, xs: Seq[Int]): Seq[Seq[Int]] = {
      if (n == xs.length) {
        result :+ xs
      } else if (n > xs.length) {
        result
      } else {
        (0 until xs.length).flatMap(i => innerCombinations(result, n, (xs.take(i)) ++ (xs.drop(i + 1)))).distinct
      }
    }

    innerCombinations(Seq(), n, xs).iterator
  }
}

